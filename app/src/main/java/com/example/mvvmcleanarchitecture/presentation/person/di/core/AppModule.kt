package com.example.mvvmcleanarchitecture.presentation.person.di.core

import android.content.Context
import com.example.mvvmcleanarchitecture.presentation.person.di.person.PersonSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [PersonSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}