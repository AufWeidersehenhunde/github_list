package com.example.githabapi.Retrofit

import com.example.githabapi.Retrofit.RetrofitInst.api
import com.example.githabapi.GithubList


class RepositoryAPI {
    suspend fun getGithub(since: Int): GithubList {
        val itemsList: GithubList?
        itemsList = api.getRepositories(since).body() ?: GithubList(listOf())
        return itemsList
    }
}

