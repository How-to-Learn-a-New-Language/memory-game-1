plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.snatik.matches"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.snatik.matches"
        minSdk = 24
        targetSdk = 36
        versionCode = 1007
        versionName = "1.01.001007"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.androidx.fragment)

    testImplementation(libs.junit)
}
