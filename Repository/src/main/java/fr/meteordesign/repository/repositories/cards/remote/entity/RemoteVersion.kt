package fr.meteordesign.repository.repositories.cards.remote.entity

import com.google.gson.annotations.SerializedName

data class RemoteVersion(
    @SerializedName("date") val date: String?,
    @SerializedName("version") val version: String?
)