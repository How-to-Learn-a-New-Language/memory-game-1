# Memory Game

We just wanted a simple memory game for kids 4+ age. No ads, no complicated screens, but a straightforward nice looking, working and open source game.

### Features

- 3 Themes : `Animals` :cat2: `Monsters` :octopus: & `Emojis` :smile:  
- 6 types of difficulties :star2:
- Sounds on winning :musical_note:

If you have more ideas or you want to add more options / themes / sounds or whatever, fill free to update the source for yourself or open a pull request. :sparkles:

### Getting started in Android Studio

1. Install [Android Studio](https://developer.android.com/studio): Otter (2025.2.1) or newer.
2. On the Welcome screen click **Clone Repository**, or with a project open choose **File > New > Project from Version Control...**.
3. Paste `https://github.com/How-to-Learn-a-New-Language/memory-game-1.git` and click **Clone**. Choose **Trust Project** if asked.
4. Wait for the Gradle sync to finish. The first sync downloads Gradle and the Android libraries, so it can take a few minutes. If Android Studio asks to install the Android 16 (API 36) SDK platform, accept.
5. Pick an emulator or a connected device and press **Run**.

Android Studio may offer to upgrade the Android Gradle Plugin (AGP). You don't need to: the project stays on AGP 8.13 so that it also opens in older Android Studio versions, which can't open newer AGP versions.

| Build setup | Version |
|---|---|
| Gradle (wrapper) | 9.4.1 |
| Android Gradle Plugin | 8.13.2 |
| `compileSdk` / `targetSdk` | 36 (Android 16) |
| `minSdk` | 24 (Android 7.0) |
| Java language level | 17 (built with the JDK that comes with Android Studio) |

Library versions are kept in [`gradle/libs.versions.toml`](gradle/libs.versions.toml).

<img src="http://www.sromku.com/static/img/pregnancy_memorygame_preview.png"/>

### Download It

<a href="https://play.google.com/store/apps/details?id=com.snatik.matches">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

### Next

- [ ] 2 player game
- [x] Add one more theme
- [ ] Add more sounds
- [ ] Add Game Services support 

### License

- The code is: `Apache License 2.0` (See [LICENSE](./LICENSE) for details.)
- For UI assets please check the licenses here:
	- http://graphicriver.net/item/animals-collection-farm-and-domestic-set/7177721
	- http://graphicriver.net/item/monster-creation-kit-and-large-pack/8851390
	- http://graphicriver.net/item/10-fresh-game-backgrounds/9137937
	- http://graphicriver.net/item/cartoon-games-gui-pack-11-/6056785

