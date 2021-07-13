package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.domain.repository.PersonRepository
import com.example.mvvmcleanarchitecture.domain.usercase.GetPersonUserCase
import com.example.mvvmcleanarchitecture.domain.usercase.UpdatePersonsUserCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule
{@Singleton
    @Provides
    fun providesGetPersonUserCase(personRepository: PersonRepository):GetPersonUserCase{
        return GetPersonUserCase(personRepository)
    }
    @Singleton
@Provides
    fun providesUpdatePersonsUserCase(personRepository: PersonRepository):UpdatePersonsUserCase{
return  UpdatePersonsUserCase(personRepository)
    }
}
