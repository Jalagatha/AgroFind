plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.ivanj.agrofind"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ivanj.agrofind"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    // ZXing library for QR code scanning
//    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
//    implementation ("com.google.mlkit:barcode-scanning:17.0.0")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.10-1.0.9")



    // AndroidX camera dependency for scanning QR codes
//    implementation ("androidx.camera:camera-core:1.0.0")
//    implementation ("androidx.camera:camera-camera2:1.0.0")
//    implementation ("androidx.camera:camera-lifecycle:1.0.0")
//    implementation ("androidx.camera:camera-view:1.0.0-alpha23")

    // QR Code generation (for generating QR codes)
    implementation ("androidmads.library:qrgenerator:1.0.3")

    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation ("com.google.zxing:core:3.4.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")

    implementation ("androidx.room:room-runtime:2.6.1")



}
