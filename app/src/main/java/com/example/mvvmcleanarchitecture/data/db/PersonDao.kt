package com.example.mvvmcleanarchitecture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


import com.example.mvvmcleanarchitecture.data.model.person.Person




@Dao
interface PersonDao {
@SuppressWarnings
    @Insert
    suspend fun savePersons(persons : List<Person>)

@SuppressWarnings
    @Query("SELECT * FROM popular_movies")
    suspend fun getPersons():List<Person>



@SuppressWarnings
    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllPersons()


}

