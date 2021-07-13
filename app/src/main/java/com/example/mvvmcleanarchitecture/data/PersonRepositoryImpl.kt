package com.example.mvvmcleanarchitecture.data

import android.util.Log
import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasourceimpl.PersonLocalDataSourceImpl
import com.example.mvvmcleanarchitecture.domain.repository.PersonRepository
import java.lang.Exception

class PersonRepositoryImpl(
    private val personCacheDataSource: PersonCacheDataSource,
    private val personLocalDataSource: PersonLocalDataSource,
    private val personRemoteDataSource: PersonRemoteDataSource
) : PersonRepository {
    override suspend fun getPersons(): List<Person>? {
        return getPersonsFromCache()
    }

    override suspend fun updatePersons(): List<Person>? {
        val newListOfPerson = getPersonsFromAPI()
        personLocalDataSource.clearAll()
        personLocalDataSource.updatePersonToDB(newListOfPerson)
        personCacheDataSource.updatePersonToCache(newListOfPerson)
        return newListOfPerson
    }
    suspend fun getPersonsFromAPI(): List<Person> {
        lateinit var artistList: List<Person>
        try {
            val response = personRemoteDataSource.getPersons()
            val body = response.body()
            if(body!=null){
                artistList = body.people
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getPersonsFromCache():List<Person>{
        lateinit var personList: List<Person>
        try {
            personList =personCacheDataSource.getPersonFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(personList.size>0){
            return personList
        }else{
            personList=getPersonsFromDB()
            personCacheDataSource.updatePersonToCache(personList)
        }

        return personList
    }
    suspend fun getPersonsFromDB():List<Person>{
        lateinit var personList: List<Person>
        try {
            personList = personLocalDataSource.getPersonFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(personList.size>0){
            return personList
        }else{
            personList=getPersonsFromDB()
            personLocalDataSource.updatePersonToDB(personList)
        }

        return personList
    }

}