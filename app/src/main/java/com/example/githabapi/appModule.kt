package com.example.githabapi

import androidx.room.Room


import com.example.githabapi.DBandprovider.DBprovider
import com.example.githabapi.HomeFragment.HomeViewModel
import com.example.githabapi.InfoFragment.InfoViewModel
import com.example.githabapi.Retrofit.RepositoryAPI
import com.example.githabapi.Retrofit.RetrofitInst
import com.example.githubapi.repository.RepositorySQLite
import com.github.terrakok.cicerone.Cicerone
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    viewModel { InfoViewModel(get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
//    viewModel { FavoritesViewModel(get(), get()) }
    viewModel { MainActivityViewModel(get(), get(), get()) }
//    viewModel { SortViewModel(get()) }
//    viewModel { DetailViewModel(get(), get()) }
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            DBprovider::class.java,
            "database"
        ).build()
    }
    single { RetrofitInst }
    single { get<DBprovider>().GithubDao() }
    single { RepositorySQLite(get()) }
    single { RepositoryAPI() }
}

