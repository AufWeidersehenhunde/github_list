package com.example.githabapi.HomeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.RepositoryRemoteItemEntity

import com.example.githabapi.Retrofit.RepositoryAPI
import com.example.githabapi.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class HomeViewModel (
    private val router: Router,
    private val repositoryAPI: RepositoryAPI
): ViewModel() {
    private val _listRepositories = MutableStateFlow<List<RepositoryRemoteItemEntity?>>(listOf())
    val listRepositories : MutableStateFlow<List<RepositoryRemoteItemEntity?>> = _listRepositories
    init {
        observeAllRepositories()
    }

    fun observeRepositories(since: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characters = repositoryAPI.getGithub(since)
            _listRepositories.value = characters.toMutableList()
        }
    }

    fun updateToBegins(){
        router.newRootScreen(Screens.getHomeFragment())
    }

    fun observeAllRepositories()  {
        viewModelScope.launch {
            val repositories = repositoryAPI.getGithub(0)
                _listRepositories.value = repositories.toMutableList()
            }
        }

    fun routeToInfo(model: RepositoryRemoteItemEntity) {
        router.newRootScreen(Screens.getInfoFragment(model))
    }

}