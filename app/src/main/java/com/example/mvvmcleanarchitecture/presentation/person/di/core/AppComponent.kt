package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.presentation.person.di.person.PersonSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
       AppModule::class,
       NetModule::class,
       DataBaseModule::class,
       UseCaseModule::class,
       RepositoryModule::class,
       RemoteDataModule::class,
       LocalDataModule::class,
       CacheDataModule::class
])
interface AppComponent {

       fun personSubComponent():PersonSubComponent.Factory


}
