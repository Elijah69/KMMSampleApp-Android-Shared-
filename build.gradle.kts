
buildscript {
    val usr by extra(properties["dflt.usr"].toString())
    val pwd by extra(properties["dflt.pwd"].toString())
    val kotlinVersion by extra("1.5.20-M1-107")
    repositories {
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
            credentials {
                username = usr
                password = pwd
            }
        }
        maven {
            url = uri("https://kotlin.jetbrains.space/p/kotlin/packages/maven/dev")
            credentials {
                username = pwd
                password = pwd
            }
        }
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:4.2.1")
    }
}

allprojects {
    val usr by extra(properties["dflt.usr"].toString())
    val pwd by extra(properties["dflt.pwd"].toString())
    repositories {
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
            credentials {
                username = usr
                password = pwd
            }
        }
        maven {
            url = uri("https://kotlin.jetbrains.space/p/kotlin/packages/maven/dev")
            credentials {
                username = usr
                password = pwd
            }
        }
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}