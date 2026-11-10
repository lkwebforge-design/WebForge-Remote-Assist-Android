plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.webforge.remoteassist"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.webforge.remoteassist"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }

    buildFeatures { buildConfig = true }
}
