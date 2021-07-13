package com.example.mvvmcleanarchitecture.data.api

import com.example.mvvmcleanarchitecture.data.model.person.PersonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MVVMService {



    @GET("movie/popular")
    suspend fun getPopularPersons(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<PersonList>
}
