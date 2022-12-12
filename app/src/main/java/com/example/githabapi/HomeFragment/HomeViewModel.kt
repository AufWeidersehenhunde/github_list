package com.example.githabapi.HomeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.RepositoryRemoteItemEntity

import com.example.githabapi.Retrofit.RepositoryAPI
import com.example.githabapi.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class HomeViewModel (
    private val router: Router,
    private val repositoryAPI: RepositoryAPI
): ViewModel() {
    private val _listRepositories = MutableStateFlow<List<RepositoryRemoteItemEntity?>>(emptyList())
    val listRepositories : MutableStateFlow<List<RepositoryRemoteItemEntity?>> = _listRepositories
    init {
        observeAllPersons()
    }

    fun observeAllPersons()  {
        viewModelScope.launch {
            val repositories = repositoryAPI.getGithub()
                _listRepositories.value = repositories
            }
        }

    fun routeToInfo(model: RepositoryRemoteItemEntity) {
        router.newRootScreen(Screens.getInfoFragment(model))
    }

}