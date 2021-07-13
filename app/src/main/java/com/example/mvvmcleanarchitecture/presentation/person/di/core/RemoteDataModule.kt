package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.data.api.MVVMService
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasourceimpl.PersonRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val baseUrl :String) {
@Singleton
    @Provides
    fun providesPersonRemoteDataSource(mvvmService: MVVMService):PersonRemoteDataSource{
        return PersonRemoteDataSourceImpl(mvvmService, baseUrl)
    }
}