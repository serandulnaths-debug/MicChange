import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

fun getKeystoreProperty(key: String): String {
    val propsFile = rootProject.file("keystore.properties")
    if (propsFile.exists()) {
        val props = Properties()
        FileInputStream(propsFile).use { props.load(it) }
        val propValue = props.getProperty(key)
        if (propValue != null) {
            return propValue
        }
    }
    return System.getenv(key) ?: ""
}

android {
    namespace = "com.example.audiorouter"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.audiorouter"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            val storeFilePath = getKeystoreProperty("STORE_FILE")
            storeFile = if (storeFilePath.isNotEmpty()) file(storeFilePath) else file("../release.keystore")
            storePassword = getKeystoreProperty("STORE_PASSWORD")
            keyAlias = getKeystoreProperty("KEY_ALIAS")
            keyPassword = getKeystoreProperty("KEY_PASSWORD")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    lint {
        abortOnError = false
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Shizuku
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}
