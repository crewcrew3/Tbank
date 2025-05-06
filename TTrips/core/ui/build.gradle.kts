plugins {
//    alias(libs.plugins.android.library)
//    alias(libs.plugins.kotlin.android)
    id("base-android-plugin-compose")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.itis.t_trips.ui"
//    compileSdk = 34

    defaultConfig {
//        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

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

//не получилось вынести в конвеншн плагин
composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}

dependencies {
    //implementation(libs.androidx.core.ktx)
}