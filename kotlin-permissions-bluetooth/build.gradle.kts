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

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.moko.permissions.bluetooth)
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
        }

        listOf(
            jsMain, jvmMain,
            macosX64Main,
            macosArm64Main,
            linuxX64Main,
            linuxArm64Main,
            mingwX64Main
        ).forEach { it.dependsOn(commonStubMain) }
    }
}

android {
    namespace = "eu.codlab.permissions.bluetooth"
}
