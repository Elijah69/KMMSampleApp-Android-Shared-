
buildscript {
    val usr by extra(properties["dflt.usr"].toString())
    val pwd by extra(properties["dflt.pwd"].toString())
    val sql_delight_version by extra("1.6.0-SNAPSHOT")
    val kotlinVersion by extra("1.5.30-dev-1320")
    val agpVersion by extra("4.2.1")
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
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        }
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:$agpVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sql_delight_version")
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
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        }
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}