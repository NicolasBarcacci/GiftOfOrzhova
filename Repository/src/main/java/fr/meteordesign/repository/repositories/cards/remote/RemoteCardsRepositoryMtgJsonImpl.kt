package fr.meteordesign.repository.repositories.cards.remote

import android.content.SharedPreferences
import fr.giftoforzhova.common.Optional
import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteVersion
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

internal const val MTJ_JSON_BASE_URL = "https://mtgjson.com/"

internal const val REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME = "remote_cards_repository"
internal const val KEY_REMOTE_VERSION = "remote_cards_repository"

class RemoteCardsRepositoryMtgJsonImpl @Inject constructor(
    @Named(REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME) private val preferences: SharedPreferences,
    private val api: MtgJsonCardsApi
) : RemoteCardsRepository {

    override fun getSavedVersion(): Single<Optional<String>> = Single.just(
        Optional(preferences.getString(KEY_REMOTE_VERSION, null))
    )

    override fun getCurrentVersion(): Single<RemoteVersion> =
        api.getVersion()
            .subscribeOn(Schedulers.io())


    override fun getSets(): Single<List<RemoteSet>> =
        api.getSets()
            .subscribeOn(Schedulers.io())

    override fun getSetCards(setCode: String): Single<RemoteSet> =
        api.getSetCards(setCode)
            .subscribeOn(Schedulers.io())
}