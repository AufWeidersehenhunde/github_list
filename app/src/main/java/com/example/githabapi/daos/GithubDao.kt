package com.example.githabapi.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githabapi.DBandprovider.GithubDb
import kotlinx.coroutines.flow.Flow


@Dao
interface GitDao {
    @Query("SELECT * FROM repositories WHERE id =:uuid")
    suspend fun getItemForId(uuid: Int): GithubDb

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllData(list: List<GithubDb>)

    @Query("SELECT * FROM repositories")
    fun observeAllSomethingData(): Flow<List<GithubDb>>

//    @Query("SELECT * FROM persons")
//    fun observeAllSomethingData(): Flow<List<PersonDb>>
//
//    @Query("SELECT * FROM persons WHERE isFavorite = 1")
//    fun observeAllFavoriteData(): Flow<List<PersonDb>>
//
//    @Query("UPDATE persons SET isFavorite = 1 WHERE id =:uuid ")
//    suspend fun putInFavorite(uuid: Int)
//
//    @Query("SELECT * FROM persons WHERE id =:uuid")
//    suspend fun getItemForId(uuid: Int): PersonDb
//
//    @Query("UPDATE persons SET isFavorite = 0 WHERE id =:uuid ")
//    suspend fun deleteFavoritePerson(uuid: Int)
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertAllData(list: List<PersonDb>)
//
//    @Delete
//    suspend fun deletePerson(it: PersonDb)
//
//    @Query("SELECT*FROM persons WHERE status = :statusApi and gender = :genderApi and species = :speciesApi")
//    suspend fun putInSort(statusApi: String, genderApi: String, speciesApi: String) : List<PersonDb>
//
//    @Query("SELECT*FROM persons WHERE name  LIKE :any OR gender LIKE :any")
//    suspend fun putInSearch(any:String): List<PersonDb>

}