package com.example.mvvmcleanarchitecture.domain.repository

import com.example.mvvmcleanarchitecture.data.model.person.Person

interface PersonRepository {

    suspend fun getPersons():List<Person>?
    suspend fun updatePersons():List<Person>?
}