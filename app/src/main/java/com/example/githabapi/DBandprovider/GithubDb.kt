package com.example.githabapi.DBandprovider

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repositories")
data class GithubDb(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "login") val login: String?,
    @ColumnInfo(name = "description") val description: String?,

)