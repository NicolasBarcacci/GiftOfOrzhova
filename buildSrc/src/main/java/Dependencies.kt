private object DependenciesVersions {
    const val androidXCoreKtx = "1.0.1"

    const val androidXAppCompat = "1.0.2"
    const val constraintLayout = "1.1.3"
    const val material = "1.0.0"

    const val dagger = "2.21"
    const val navigation = "1.0.0-rc02"
    const val rxJava = "2.2.7"
    const val rxAndroid = "2.1.1"
    const val retrofit = "2.5.0"
    const val room = "2.0.0"

    const val timber = "4.7.1"
    const val glide = "4.9.0"

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
    const val daggerAndroid = "com.google.dagger:dagger-android:${DependenciesVersions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${DependenciesVersions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${DependenciesVersions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${DependenciesVersions.dagger}"

    // Guide : https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing
    // Artifact : https://mvnrepository.com/artifact/android.arch.navigation/navigation-fragment
    const val navigation = "android.arch.navigation:navigation-fragment:${DependenciesVersions.navigation}"

    // Artifact : https://search.maven.org/search?q=g:io.reactivex.rxjava2%20a:rxjava
    const val rxJava = "io.reactivex.rxjava2:rxjava:${DependenciesVersions.rxJava}"

    // Guide : https://github.com/ReactiveX/RxAndroid
    // Artifact : https://search.maven.org/search?q=g:io.reactivex.rxjava2%20a:rxandroid
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${DependenciesVersions.rxAndroid}"

    // Guide : https://square.github.io/retrofit/
    // Artifact : https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${DependenciesVersions.retrofit}"

    // Artifact : https://mvnrepository.com/artifact/com.squareup.retrofit2/adapter-rxjava2
    const val retrofitAdapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${DependenciesVersions.retrofit}"

    // Artifact : https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${DependenciesVersions.retrofit}"

    // Guide : https://developer.android.com/training/data-storage/room/index.html
    // Artifact : https://mvnrepository.com/artifact/androidx.room/room-runtime
    const val room = "androidx.room:room-runtime:${DependenciesVersions.room}"

    // Artifact : https://mvnrepository.com/artifact/androidx.room/room-rxjava2
    const val roomRxJava2 = "androidx.room:room-rxjava2:${DependenciesVersions.room}"

    // Artifact : https://mvnrepository.com/artifact/androidx.room/room-compiler
    const val roomCompiler = "androidx.room:room-compiler:${DependenciesVersions.room}"

    // https://github.com/JakeWharton/timber
    const val timber = "com.jakewharton.timber:timber:${DependenciesVersions.timber}"

    const val glide = "com.github.bumptech.glide:glide:${DependenciesVersions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${DependenciesVersions.glide}"


    // https://github.com/junit-team/junit4
    const val junit = "junit:junit:${DependenciesVersions.junit}"
}
