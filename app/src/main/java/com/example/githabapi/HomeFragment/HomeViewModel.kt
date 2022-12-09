package com.example.githabapi.HomeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.DBandprovider.GithubDb
import com.example.githabapi.Screens
import com.example.githubapi.repository.RepositorySQLite
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel (
    private val router: Router,
    private val repositorySQLite: RepositorySQLite

): ViewModel() {
    private val _listCharacters = MutableStateFlow<List<GithubDb>>(emptyList())
    val listCharacters: MutableStateFlow<List<GithubDb>> = _listCharacters

    fun observeAllPersons()  {
        viewModelScope.launch {
            repositorySQLite.observeAllSomethingData().collect{
                _listCharacters.value = it
            }
        }
    }
    fun routeToInfo(uuid: Int) {
        router.newRootScreen(Screens.getInfoFragment(uuid))
    }




}