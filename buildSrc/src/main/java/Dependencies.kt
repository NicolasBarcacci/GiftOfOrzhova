private object DependenciesVersions {
    const val androidXCoreKtx = "1.0.1"

    const val androidXAppCompat = "1.0.2"
    const val constraintLayout = "1.1.3"
    const val material = "1.0.0"

    const val dagger = "2.21"
    const val navigation = "1.0.0-rc02"

    const val timber = "4.7.1"

    const val junit = "4.12"
}

object Dependencies {

    // https://github.com/JetBrains/kotlin/blob/master/ChangeLog.md
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${PluginsVersions.kotlin}"

    // Guide : https://developer.android.com/kotlin/ktx#kotlin
    // Artifact : https://mvnrepository.com/artifact/androidx.core/core-ktx
    const val androidXCoreKTX = "androidx.core:core-ktx:${DependenciesVersions.androidXCoreKtx}"


    // Artifact : https://mvnrepository.com/artifact/androidx.appcompat/appcompat
    const val androidXAppCompat = "androidx.appcompat:appcompat:${DependenciesVersions.androidXAppCompat}"

    // Guide : https://developer.android.com/training/constraint-layout/
    // Artifact : https://mvnrepository.com/artifact/androidx.constraintlayout/constraintlayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${DependenciesVersions.constraintLayout}"

    // Artifact : https://mvnrepository.com/artifact/com.google.android.material/material
    const val material = "com.google.android.material:material:${DependenciesVersions.material}"

    // https://github.com/google/dagger
    const val dagger = "com.google.dagger:dagger:${DependenciesVersions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${DependenciesVersions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${DependenciesVersions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${DependenciesVersions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${DependenciesVersions.dagger}"

    // Guide : https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing
    // Artifact : https://mvnrepository.com/artifact/android.arch.navigation/navigation-fragment
    const val navigation = "android.arch.navigation:navigation-fragment:${DependenciesVersions.navigation}"


    // https://github.com/JakeWharton/timber
    const val timber = "com.jakewharton.timber:timber:${DependenciesVersions.timber}"


    // https://github.com/junit-team/junit4
    const val junit = "junit:junit:${DependenciesVersions.junit}"
}
