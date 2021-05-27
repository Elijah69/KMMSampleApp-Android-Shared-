import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
}

version ="0.1"

kotlin {
    //System.getenv().forEach { t, u -> println("$t $u") }
    android()

    watchosX64() { }
//    ios() {
//        binaries {
//            framework {
//                baseName = "ios"
//            }
//        }
//    }
    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") { }
    cocoapods {
        watchos.deploymentTarget = "7.4"
        ios.deploymentTarget = "14.1"
        summary = "shared pod"
        homepage = "no page"
        frameworkName = "shared"
        podfile = project.file("../../SepparatedApp(iOS)/Podfile")
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting
        val iosTest by getting
        val watchosX64Main by getting
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