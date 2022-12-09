package com.example.githubapi.repository

import com.example.githabapi.DBandprovider.GithubDb
import com.example.githabapi.daos.GitDao


class RepositorySQLite(
    private val gitDao: GitDao
) {
    fun insertAllData(list: List<GithubDb>) = gitDao.insertAllData(list)

    suspend fun getInfo(uuid: Int) = gitDao.getItemForId(uuid)

    fun observeAllSomethingData() = gitDao.observeAllSomethingData()



}


