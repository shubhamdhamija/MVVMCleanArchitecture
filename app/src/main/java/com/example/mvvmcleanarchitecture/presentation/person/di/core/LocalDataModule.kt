package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.data.db.PersonDao
import com.example.mvvmcleanarchitecture.data.repository.datasource.PersonLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.datasourceimpl.PersonLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun providesPersonLocalDataSource(personDao: PersonDao): PersonLocalDataSource {
        return  PersonLocalDataSourceImpl(personDao)
    }
}