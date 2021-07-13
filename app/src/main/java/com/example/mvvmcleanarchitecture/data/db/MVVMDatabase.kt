package com.example.mvvmcleanarchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmcleanarchitecture.data.model.person.Person


@Database(entities = [Person::class],
    version = 1,
    exportSchema = false
)
abstract class MVVMDatabase : RoomDatabase(){
    abstract fun personDao(): PersonDao


}
