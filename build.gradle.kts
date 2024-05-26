plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    alias(libs.plugins.sqlDelight).apply(false)
    alias(libs.plugins.hilt).apply(false)
//    classpath ( dependencyNotation: "com. google.dagger :hilt-android-gradle-plugin:2.42")
}