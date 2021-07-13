package com.example.mvvmcleanarchitecture.data.repository.datasourceimpl

import com.example.mvvmcleanarchitecture.data.db.PersonDao
import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonLocalDataSourceImpl(private val personDao: PersonDao): PersonLocalDataSource {
    override suspend fun getPersonFromDB(): List<Person> {
        return  personDao.getPersons()
    }

    override suspend fun updatePersonToDB(persons: List<Person>) {
        CoroutineScope(Dispatchers.IO).launch {
            personDao.savePersons(persons)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            personDao.deleteAllPersons()
        }
    }


}