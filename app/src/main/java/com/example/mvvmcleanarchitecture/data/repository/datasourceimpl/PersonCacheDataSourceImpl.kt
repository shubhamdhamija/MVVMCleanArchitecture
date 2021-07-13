package com.example.mvvmcleanarchitecture.data.repository.datasourceimpl

import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonCacheDataSource

class PersonCacheDataSourceImpl : PersonCacheDataSource {

    private var personList = ArrayList<Person>()
    override suspend fun getPersonFromCache(): List<Person> {
     return  personList
    }

    override suspend fun updatePersonToCache(persons: List<Person>) {
        personList.clear()
      personList = ArrayList(persons)
    }
}