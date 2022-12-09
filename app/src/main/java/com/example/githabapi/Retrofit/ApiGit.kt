package com.example.githabapi.Retrofit


import com.example.githabapi.GithubList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGit {
    @GET("repositories")
    suspend fun getRepositories(@Query("since") since:Int):Response<GithubList>

}