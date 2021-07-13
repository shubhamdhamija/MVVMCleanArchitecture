package com.example.mvvmcleanarchitecture.data.repository.datasourceimpl

import com.example.mvvmcleanarchitecture.data.api.MVVMService
import com.example.mvvmcleanarchitecture.data.model.person.PersonList
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonRemoteDataSource
import retrofit2.Response

class PersonRemoteDataSourceImpl(private  val mvvmService: MVVMService, private val baseUrl: String ):
    PersonRemoteDataSource {
    override suspend fun getPersons(): Response<PersonList> = mvvmService.getPopularPersons(baseUrl)

}