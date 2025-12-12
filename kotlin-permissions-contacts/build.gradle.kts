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
                api(project(":kotlin-permissions"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.moko.permissions.contacts)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.moko.permissions.contacts)
            }
        }

        val jsMain by getting
        val jvmMain by getting
        val macosX64Main by getting
        val macosArm64Main by getting
        val linuxX64Main by getting
        val linuxArm64Main by getting
        val mingwX64Main by getting
        val commonStubMain by creating {
            dependsOn(commonMain)
            jsMain.dependsOn(this)
            jvmMain.dependsOn(this)
            macosX64Main.dependsOn(this)
            macosArm64Main.dependsOn(this)
            linuxX64Main.dependsOn(this)
            linuxArm64Main.dependsOn(this)
            mingwX64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "eu.codlab.permissions.contacts"
}
