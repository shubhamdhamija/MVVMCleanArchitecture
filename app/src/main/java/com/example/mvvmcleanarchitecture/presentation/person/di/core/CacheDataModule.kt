package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasourceimpl.PersonCacheDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.datasourceimpl.PersonLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesPersonCacheDataSource():PersonCacheDataSource{
        return  PersonCacheDataSourceImpl()
    }
}