package com.example.githabapi.Retrofit

import com.example.githabapi.RepositoryRemoteItemEntity
import com.example.githabapi.Retrofit.RetrofitInst.api



class RepositoryAPI {
    suspend fun getGithub(since:Int): List<RepositoryRemoteItemEntity> {
        val itemsList: List<RepositoryRemoteItemEntity>?
        itemsList = api.getFuckingRepo(since).body() ?: (listOf ())
        return itemsList
    }
}

