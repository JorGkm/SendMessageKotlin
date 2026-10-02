plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.dokka)
}

android {
    namespace = "com.example.sendmessage"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.sendmessage"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    //implementation(libs.aboutus)
}
// Configuración de rutas personalizadas para Dokka
dokka {
    moduleName.set("SendMessage") //Este nombre puede ser aleatorio, pero conviene que sea el del proyecto

    dokkaPublications.html {
        outputDirectory.set(rootProject.file("documentation"))
    }

    dokkaSourceSets {
        register("main") {
            //sourceRoots.from(file("src/main/java"))
            jdkVersion.set(21)
            enableAndroidDocumentationLink.set(false)
        }
    }
}