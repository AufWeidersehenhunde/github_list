package com.example.githabapi.Retrofit

import com.example.githabapi.RepositoryRemoteItemEntity
import com.example.githabapi.Retrofit.RetrofitInst.api



class RepositoryAPI {
    suspend fun getGithub(): List<RepositoryRemoteItemEntity> {
        val itemsList: List<RepositoryRemoteItemEntity>?
        itemsList = api.getFuckingRepo().body() ?: (listOf ())
        return itemsList
    }
}

