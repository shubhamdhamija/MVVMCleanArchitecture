package com.example.mvvmcleanarchitecture.data.repository.datasource

import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.example.mvvmcleanarchitecture.data.model.person.PersonList
import retrofit2.Response

interface PersonRemoteDataSource {
    suspend fun getPersons():Response<PersonList>
}