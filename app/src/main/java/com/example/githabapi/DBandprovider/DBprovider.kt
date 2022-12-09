package com.example.githabapi.DBandprovider

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githabapi.daos.GitDao


@Database(entities = [GithubDb::class], version = 1)
abstract class DBprovider : RoomDatabase() {
    abstract fun GithubDao(): GitDao
}