plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Plugin 'kotlin.compose' tidak ada, yang benar adalah 'org.jetbrains.kotlin.plugin.compose'
    // Saya asumsikan Anda telah mendefinisikannya di libs.versions.toml
    // Jika tidak, ganti 'alias(libs.plugins.kotlin.compose)' dengan:
    // id("org.jetbrains.kotlin.plugin.compose") version "1.6.10" // (atau versi yang sesuai)
    // Tapi, mari kita asumsikan 'libs.plugins.kotlin.compose' sudah benar di-setup di TOML
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.praktikum_bp3"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.praktikum_bp3"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        // Sesuaikan dengan JDK 21 Anda
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        // Sesuaikan dengan JDK 21 Anda
        jvmTarget = "21"
    }
    buildFeatures {
        compose = true
    }
    // Menambahkan composeOptions jika Anda menggunakan plugin compose
    composeOptions {
        // Sesuaikan versi kotlinCompilerExtensionVersion di libs.versions.toml
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
