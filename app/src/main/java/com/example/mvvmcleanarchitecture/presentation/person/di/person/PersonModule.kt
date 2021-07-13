package com.example.mvvmcleanarchitecture.presentation.person.di.person

import com.example.mvvmcleanarchitecture.domain.usercase.GetPersonUserCase
import com.example.mvvmcleanarchitecture.domain.usercase.UpdatePersonsUserCase
import com.example.mvvmcleanarchitecture.presentation.person.PersonViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PersonModule {
@PersonScope
    @Provides
    fun providesPersonViewModelFactory(getPersonUserCase: GetPersonUserCase
, updatePersonsUserCase: UpdatePersonsUserCase):PersonViewModelFactory{
        return PersonViewModelFactory(getPersonUserCase,updatePersonsUserCase)
    }
}