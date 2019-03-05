private object DependenciesVersions {
    const val androidXCoreKtx = "1.0.1"
    const val androidXAppCompat = "1.0.2"
    const val constraintLayout = "1.1.3"

    const val junit = "4.12"
}

object Dependencies {

    // https://github.com/JetBrains/kotlin/blob/master/ChangeLog.md
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${PluginsVersions.kotlin}"

    // Artifact : https://mvnrepository.com/artifact/androidx.appcompat/appcompat
    const val androidXAppCompat = "androidx.appcompat:appcompat:${DependenciesVersions.androidXAppCompat}"

    // Guide : https://developer.android.com/training/constraint-layout/
    // Artifact : https://mvnrepository.com/artifact/androidx.constraintlayout/constraintlayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${DependenciesVersions.constraintLayout}"

    // Guide : https://developer.android.com/kotlin/ktx#kotlin
    // Artifact : https://mvnrepository.com/artifact/androidx.core/core-ktx
    const val androidXCoreKTX = "androidx.core:core-ktx:${DependenciesVersions.androidXCoreKtx}"

    // https://github.com/junit-team/junit4
    const val junit = "junit:junit:${DependenciesVersions.junit}"
}
