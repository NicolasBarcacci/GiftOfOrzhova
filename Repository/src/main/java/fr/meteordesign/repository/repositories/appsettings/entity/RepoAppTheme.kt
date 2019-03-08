package fr.meteordesign.repository.repositories.appsettings.entity

enum class RepoAppTheme(val value: Int) {
    AZORIUS(0),
    BOROS(1),
    DIMIR(2),
    GOLGARI(3),
    GRUUL(4),
    IZZET(5),
    ORZHOV(6),
    RAKDOS(7),
    SELESNYA(8),
    SIMIC(9);

    companion object {
        private val map = RepoAppTheme.values().associateBy(RepoAppTheme::value)
        fun fromValue(value: Int): RepoAppTheme? = map[value]
    }
}