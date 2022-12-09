package com.example.githabapi.InfoFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.DBandprovider.GithubDb
import com.example.githubapi.repository.RepositorySQLite
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class InfoViewModel (private val router: Router,
                     private val repositorySQLite: RepositorySQLite
): ViewModel() {
    private val _listCharacters = MutableStateFlow<GithubDb?>(null)
    val listCharacters : MutableStateFlow<GithubDb?> = _listCharacters


    fun getInfoFragment(uuid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _listCharacters.value = repositorySQLite.getInfo(uuid)
        }
    }
}