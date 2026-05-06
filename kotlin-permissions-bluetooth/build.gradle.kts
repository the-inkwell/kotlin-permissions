plugins {
    alias(additionals.plugins.kotlin.multiplatform)
    alias(additionals.plugins.android.library)
    alias(additionals.plugins.kotlin.serialization)
    id("publication")
    id("jvmCompat")
}

kotlin {
    applyDefaultHierarchyTemplate()

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
                api(project(":kotlin-permissions"))
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation(libs.moko.permissions.bluetooth)
            }
        }
        val androidUnitTest by getting

        val iosMain by getting {
            dependencies {
                implementation(libs.moko.permissions.bluetooth)
            }
        }
    }
}

android {
    namespace = "eu.codlab.permissions.bluetooth"
}
