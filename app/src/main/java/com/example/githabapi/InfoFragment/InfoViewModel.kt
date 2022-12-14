package com.example.githabapi.InfoFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githabapi.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class InfoViewModel (
    private val router: Router,
): ViewModel() {
    fun back(){
        router.navigateTo(Screens.getHomeFragment())
    }
}