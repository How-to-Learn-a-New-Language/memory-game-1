package com.snatik.matches;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;

import com.snatik.matches.common.Shared;
import com.snatik.matches.engine.Engine;
import com.snatik.matches.engine.ScreenController;
import com.snatik.matches.engine.ScreenController.Screen;
import com.snatik.matches.events.EventBus;
import com.snatik.matches.events.ui.BackGameEvent;
import com.snatik.matches.ui.PopupManager;
import com.snatik.matches.utils.Utils;

public class MainActivity extends FragmentActivity {

	private ImageView mBackgroundImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);

		Shared.context = getApplicationContext();
		Shared.engine = Engine.getInstance();
		Shared.eventBus = EventBus.getInstance();

		setContentView(R.layout.activity_main);
		mBackgroundImage = (ImageView) findViewById(R.id.background_image);

		// full screen game: hide the status and navigation bars
		hideSystemBars();
		avoidDisplayCutout(findViewById(R.id.fragment_container));
		avoidDisplayCutout(findViewById(R.id.popup_container));

		// handles both the back button and the back gesture
		getOnBackPressedDispatcher().addCallback(this, mBackCallback);

		Shared.activity = this;
		Shared.engine.start();
		Shared.engine.setBackgroundImageView(mBackgroundImage);

		// set background
		setBackgroundImage();

		// set menu
		ScreenController.getInstance().openScreen(Screen.MENU);


	}

	@Override
	protected void onDestroy() {
		Shared.engine.stop();
		super.onDestroy();
	}

	private final OnBackPressedCallback mBackCallback = new OnBackPressedCallback(true) {

		@Override
		public void handleOnBackPressed() {
			if (PopupManager.isShown()) {
				PopupManager.closePopup();
				if (ScreenController.getLastScreen() == Screen.GAME) {
					Shared.eventBus.notify(new BackGameEvent());
				}
			} else if (ScreenController.getInstance().onBack()) {
				finish();
			}
		}
	};

	private void hideSystemBars() {
		WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
		// the bars come back for a moment when the player swipes in from the edge of the screen
		controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
		controller.hide(WindowInsetsCompat.Type.systemBars());
	}

	/**
	 * Keeps the view's content clear of a camera notch / cut-out. The background
	 * image still fills the whole screen.
	 */
	private void avoidDisplayCutout(View view) {
		ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() {

			@Override
			public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
				Insets cutout = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
				v.setPadding(cutout.left, cutout.top, cutout.right, cutout.bottom);
				return insets;
			}
		});
	}

	private void setBackgroundImage() {
		Bitmap bitmap = Utils.scaleDown(R.drawable.background, Utils.screenWidth(), Utils.screenHeight());
		bitmap = Utils.crop(bitmap, Utils.screenHeight(), Utils.screenWidth());
		bitmap = Utils.downscaleBitmap(bitmap, 2);
		mBackgroundImage.setImageBitmap(bitmap);
	}

}
