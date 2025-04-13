plugins {
    alias(additionals.plugins.kotlin.multiplatform)
    alias(additionals.plugins.android.library)
    alias(additionals.plugins.kotlin.serialization)
    id("publication")
    id("jvmCompat")
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }

    jvm()

    js(IR) {
        browser()
    }

    macosX64()
    macosArm64()

    mingwX64()

    linuxX64()
    linuxArm64()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(additionals.kotlinx.coroutines)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation(libs.moko.permissions)
                implementation(additionals.androidx.appcompat)
                implementation(additionals.kotlinx.coroutines.android)
            }
        }
        val androidUnitTest by getting

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.moko.permissions)
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(additionals.kotlinx.coroutines.jvm)
            }
        }

        val macosX64Main by getting {}
        val macosArm64Main by getting {}
        val linuxX64Main by getting {}
        val linuxArm64Main by getting {}
        val mingwX64Main by getting {}
        val nativeMain by creating {
            dependsOn(commonMain)
            macosX64Main.dependsOn(this)
            macosArm64Main.dependsOn(this)
            linuxX64Main.dependsOn(this)
            linuxArm64Main.dependsOn(this)
            mingwX64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "eu.codlab.permissions"
}
