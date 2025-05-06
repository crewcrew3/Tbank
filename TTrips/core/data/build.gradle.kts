plugins {
//    alias(libs.plugins.android.library)
//    alias(libs.plugins.kotlin.android)
    id("base-android-plugin")
}

android {
    namespace = "ru.itis.t_trips.data"
//    compileSdk = 34
//
    defaultConfig {
//        minSdk = 26
        //не смогла вынести в конвеншн плагин
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}