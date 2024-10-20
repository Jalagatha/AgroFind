plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    id("com.google.devtools.ksp")
    id("kotlin-kapt")
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
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
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
//    implementation("com.google.devtools.ksp:symbol-processing-api:2.0.21-1.0.25")



    // AndroidX camera dependency for scanning QR codes
//    implementation ("androidx.camera:camera-core:1.0.0")
//    implementation ("androidx.camera:camera-camera2:1.0.0")
//    implementation ("androidx.camera:camera-lifecycle:1.0.0")
//    implementation ("androidx.camera:camera-view:1.0.0-alpha23")

    // QR Code generation (for generating QR codes)
//    implementation ("androidmads.library:qrgenerator:1.0.3")

//    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
//    implementation ("com.google.zxing:core:3.4.1")
//
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
//
//    implementation ("androidx.room:room-runtime:2.6.1")
// ML Kit Barcode Scanning library
    implementation ("com.google.mlkit:barcode-scanning:17.3.0")

// ZXing library (optional if you want to use ZXing)
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation ("com.google.zxing:core:3.5.3")

    //room

    implementation ("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
}
kapt {
    correctErrorTypes = true
    useBuildCache = true
}
