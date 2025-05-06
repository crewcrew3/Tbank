plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt.gradle.plugin)
    alias(libs.plugins.ktlint.gradle.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization.plugin)
    alias(libs.plugins.gradle.secrets.plugin)
    alias(libs.plugins.hilt.plugin)
}

android {
    namespace = "ru.itis.t_trips"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "ru.itis.t_trips"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = rootProject.extra.get("versionCode") as Int
        versionName = rootProject.extra.get("versionName") as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}

dependencies {

    //core
    implementation(projects.core.data)
    implementation(projects.core.ui)
    implementation(projects.core.navigation)
    implementation(projects.core.network)
    implementation(projects.core.domain)
    implementation(projects.core.utils)

    //features
    //implementation(projects.feature.)
    
    //androidx
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    //тестирование
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //compose
    implementation(libs.bundles.compose.deps)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //изображения
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    //корутины
    implementation(libs.coroutines.core)

    //бд
    implementation(libs.room)
    implementation(libs.room.ktx)
    ksp(libs.room.ksp)

    //полезности
    debugImplementation(libs.leak.canary)

    //навигация
    implementation(libs.nav.component)
    implementation(libs.kotlin.serialization.json)

    //сеть
    implementation(libs.bundles.network.deps)

    //DI
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.nav.compose)
}