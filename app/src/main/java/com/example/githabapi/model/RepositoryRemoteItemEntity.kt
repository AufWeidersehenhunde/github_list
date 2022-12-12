package com.example.githabapi

import com.squareup.moshi.Json

data class RepositoryRemoteItemEntity(
    @Json(name ="id") val id: Int?,
    @Json(name ="name") val name: String,
    @Json(name ="full_name") val fullName: String,
    @Json(name ="private") val isPrivate: Boolean,
    @Json(name ="owner") val owner: OwnerItemEntity,
    @Json(name ="description") val description: String?
)
