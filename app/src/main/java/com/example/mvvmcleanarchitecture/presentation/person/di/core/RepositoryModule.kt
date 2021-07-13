package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.data.PersonRepositoryImpl
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonRemoteDataSource
import com.example.mvvmcleanarchitecture.domain.repository.PersonRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
@Provides
    fun providesPersonRepository(personRemoteDataSource: PersonRemoteDataSource
    ,personCacheDataSource: PersonCacheDataSource,
    personLocalDataSource: PersonLocalDataSource):PersonRepository{
        return  PersonRepositoryImpl(personCacheDataSource,personLocalDataSource  ,personRemoteDataSource)
    }
}