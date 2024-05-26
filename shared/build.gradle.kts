plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation("com.squareup.sqldelight:runtime:1.5.3")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation("com.squareup.sqldelight:android-driver:1.5.3")
        }

        iosMain.dependencies {
            implementation("com.squareup.sqldelight:native-driver:1.5.3")
        }
    }

    task("testClasses") // what does this do?
}

sqldelight {
    databases {
        create("NoteDatabase") {
            packageName = "com.ploding.noteappkmm.database"
//            sourceFolders() = listOf("sqldelight")
        }
    }
}

android {
    namespace = "com.example.notesappkmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}