package com.example.githabapi.Retrofit

import com.example.githabapi.RepositoryRemoteItemEntity
import com.example.githabapi.Retrofit.RetrofitInst.api



class RepositoryAPI {
    suspend fun getGithub(since:Int): MutableList<RepositoryRemoteItemEntity> {
        val itemsList: MutableList<RepositoryRemoteItemEntity>?
        itemsList = api.getFuckingRepo(since).body() ?: (mutableListOf ())
        return itemsList
    }
}

