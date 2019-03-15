package fr.meteordesign.repository.repositories.cards.remote

import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteVersion
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

private const val SET_CODE = "SET_CODE"

interface MtgJsonCardsApi {

    @GET("json/version.json")
    fun getVersion(): Single<RemoteVersion>

    @GET("json/SetList.json")
    fun getSets(): Single<List<RemoteSet>>

    @GET("json/{$SET_CODE}.json")
    fun getSetCards(@Path(SET_CODE) setCode: String): Single<RemoteSet>
}