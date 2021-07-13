package com.example.mvvmcleanarchitecture.data.repository.datasource

import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.example.mvvmcleanarchitecture.data.model.person.PersonList

interface PersonCacheDataSource {

    suspend fun getPersonFromCache():List<Person>
    suspend fun updatePersonToCache(persons: List<Person>)
}