
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //kotlin("kapt") version "1.9.10"
    //id ("kotlin-kapt")
    id ("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")

}
//def apiKeyPropertiesFiles = rootProject.file("key.properties")
//def apiKeyProperties = new Properties()
//apiKeyProperties.load(new fileInputStream(apiKeyPropertiesFiles))



android {
    namespace = "com.example.digikala"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.digikala"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }


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
        sourceCompatibility = JavaVersion.VERSION_17 //1_8
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"  //1.8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"  //7=3
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.11.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    //implementation("androidx.compose.material3:material3:1.1.2")
    //implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.11.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //room
    implementation ("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    //kapt("groupId:artifactId:1.9.10")
    implementation ("androidx.room:room-ktx:2.6.1")

    //datastore
    implementation ("androidx.datastore:datastore-preferences:1.1.1")

    //hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
   // kapt ("com.google.dagger:hilt-compiler:2.51.1")
    ksp("com.google.dagger:hilt-compiler:2.51.1")

    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    //compose nav
    implementation ("androidx.navigation:navigation-compose:2.8.4")

    //animation - lottie
    implementation ("com.airbnb.android:lottie-compose:6.4.0")

    //coil - load image from url
    implementation ("io.coil-kt:coil-compose:2.6.0")

    //swipe refresh
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.34.0")

    //system ui controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    //material 2
    implementation("androidx.compose.material:material:1.7.5") //1.4.3

    // swipe refresh
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.34.0")

    //pager
    //noinspection GradleDependency
    implementation ("com.google.accompanist:accompanist-pager:0.34.0")
    //noinspection GradleDependency
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.34.0")


}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}


