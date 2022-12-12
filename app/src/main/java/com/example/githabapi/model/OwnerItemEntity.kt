package com.example.githabapi

import com.squareup.moshi.Json

data class OwnerItemEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatar_url: String
)