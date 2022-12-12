package com.example.githabapi


import com.example.githabapi.HomeFragment.HomeViewModel
import com.example.githabapi.InfoFragment.InfoViewModel
import com.example.githabapi.Retrofit.RepositoryAPI
import com.example.githabapi.Retrofit.RetrofitInst
import com.github.terrakok.cicerone.Cicerone
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    viewModel { InfoViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { MainActivityViewModel(get(), get()) }

    single { RetrofitInst }
    single { RepositoryAPI() }
}

