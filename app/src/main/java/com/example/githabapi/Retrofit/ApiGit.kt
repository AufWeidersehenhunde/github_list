package com.example.githabapi.Retrofit

import com.example.githabapi.RepositoryRemoteItemEntity
import retrofit2.Response
import retrofit2.http.GET


interface ApiGit {
    @GET("repositories")
    suspend fun getFuckingRepo():Response<List<RepositoryRemoteItemEntity>>
}