package com.example.githabapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.Retrofit.RepositoryAPI
import com.example.githubapi.repository.RepositorySQLite
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel(
    private val router: Router,
    private val repositorySQLite: RepositorySQLite,
    private val repositoryAPI: RepositoryAPI
) : ViewModel() {

    fun observeRepositories(since: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characters = repositoryAPI.getGithub(since)
            repositorySQLite.insertAllData(characters.results)
        }
    }

    fun create() {
        router.navigateTo(Screens.getHomeFragment())
    }
}