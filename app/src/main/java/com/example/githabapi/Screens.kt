package com.example.githabapi

import com.example.githabapi.HomeFragment.HomeFragment
import com.example.githabapi.InfoFragment.InfoFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
//    fun getInfoFragment(uuid: Int) = FragmentScreen { InfoFragment.getInstance(uuid) }
//
//    fun getHomeSortFragment(statusApi: String,genderApi: String,speciesApi:String) = FragmentScreen { HomeFragment.getInstance(statusApi,genderApi,speciesApi) }

    fun getHomeFragment() = FragmentScreen { HomeFragment() }
    fun getInfoFragment(uuid: Int) = FragmentScreen { InfoFragment.getInstance(uuid) }

//    fun getFavoriteFragment() = FragmentScreen { FavoritesFragment() }
//
//    fun getSortFragment() = FragmentScreen {SortFragment()}
//
//    fun getDetailFragment(image: String, uuid: Int) = FragmentScreen { DetailFragment.getInstance(image, uuid) }
}