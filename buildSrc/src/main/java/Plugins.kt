object PluginsVersions {
    const val androidGradle = "3.3.1"
    const val kotlin = "1.3.21"
}

object Plugins {

    // https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google
    const val androidGradle = "com.android.tools.build:gradle:${PluginsVersions.androidGradle}"

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-gradle-plugin
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.kotlin}"
}