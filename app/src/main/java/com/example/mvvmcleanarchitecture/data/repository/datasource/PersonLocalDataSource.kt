package com.example.mvvmcleanarchitecture.data.repository.datasource

import com.example.mvvmcleanarchitecture.data.model.person.Person

interface PersonLocalDataSource {

    suspend fun getPersonFromDB():List<Person>
    suspend fun updatePersonToDB(persons: List<Person>)
    suspend fun clearAll()
}