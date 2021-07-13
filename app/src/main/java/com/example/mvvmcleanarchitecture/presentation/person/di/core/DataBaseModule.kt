package com.example.mvvmcleanarchitecture.presentation.person.di.core

import android.content.Context
import androidx.room.Room
import com.example.mvvmcleanarchitecture.data.db.MVVMDatabase
import com.example.mvvmcleanarchitecture.data.db.PersonDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {


    @Singleton
    @Provides
    fun providesMVVMDatabase(context: Context):MVVMDatabase{
        return Room.databaseBuilder(context,MVVMDatabase::class.java, "MVVMClient").build()
    }
@Singleton
    @Provides
    fun providesPersonDao(mvvmDatabase: MVVMDatabase):PersonDao{
        return mvvmDatabase.personDao()
    }


}