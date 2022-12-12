package com.example.githabapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.Retrofit.RepositoryAPI
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel(
    private val router: Router,
    private val repositoryAPI: RepositoryAPI
) : ViewModel() {

    fun create() {
        router.navigateTo(Screens.getHomeFragment())
    }
}