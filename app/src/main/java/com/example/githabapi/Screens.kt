package com.example.githabapi

import com.example.githabapi.HomeFragment.HomeFragment
import com.example.githabapi.InfoFragment.InfoFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun getHomeFragment() = FragmentScreen { HomeFragment() }
    fun getInfoFragment(model: RepositoryRemoteItemEntity) = FragmentScreen { InfoFragment.getInstance(model) }
}