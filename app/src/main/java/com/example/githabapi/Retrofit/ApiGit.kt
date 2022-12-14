package com.example.githabapi.Retrofit

import com.example.githabapi.RepositoryRemoteItemEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiGit {
    @GET("repositories")
    suspend fun getFuckingRepo(@Query("since") since: Int):Response<List<RepositoryRemoteItemEntity>>
}