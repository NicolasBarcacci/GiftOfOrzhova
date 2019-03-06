private const val major = 1
private const val minor = 0
private const val patch = 0

object AppVersion {

    const val code: Int = major * 10000 + minor * 100 + patch

    const val name: String = "$major.$minor.$patch"
}