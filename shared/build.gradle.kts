import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version("1.5.0")
    id("com.squareup.sqldelight")
}

object Versions {
    val datatime = "0.2.1"
    val junit = "4.13.2"
    val coroutines = "1.5.0"
    val serialization = "1.2.1"
    val ktor_version = "2.0.0-eap-138"
    val sql_delight_version = "1.6.0-SNAPSHOT"
}

kotlin {
    //System.getenv().forEach { t, u -> println("$t $u") }
    android()
    //ktor don't work with watchosX64 currently
    watchosArm64(){
        binaries {
            framework("watch") {
                baseName = "watch"
            }
        }
    }
    ios() {
        binaries {
            framework("ios") {
                baseName = "ios"
            }
        }
    }
//    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
//        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
//            ::iosArm64
//        else
//            ::iosX64
//
//    iosTarget("ios") {
//        binaries {
//            framework {
//                baseName = "shared"
//            }
//        }
//    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datatime}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}")
                implementation("io.ktor:ktor-client-core:${Versions.ktor_version}")
                implementation("com.squareup.sqldelight:runtime:${Versions.sql_delight_version}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:${Versions.ktor_version}")
                implementation("com.squareup.sqldelight:android-driver:${Versions.sql_delight_version}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:${Versions.junit}")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor_version}")
                implementation("com.squareup.sqldelight:native-driver:${Versions.sql_delight_version}")
            }
        }
        val iosTest by getting
        val watchosArm64Main by getting
    }
}
sqldelight {
    database("AppDatabase") {
        packageName = "com.example.db"
    }
}
android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
}