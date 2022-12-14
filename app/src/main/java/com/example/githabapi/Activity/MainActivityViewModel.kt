package com.example.githabapi.Activity

import androidx.lifecycle.ViewModel
import com.example.githabapi.Retrofit.RepositoryAPI
import com.example.githabapi.Screens
import com.github.terrakok.cicerone.Router


class MainActivityViewModel(
    private val router: Router,
    private val repositoryAPI: RepositoryAPI
) : ViewModel() {

    fun create() {
        router.navigateTo(Screens.getHomeFragment())
    }
}