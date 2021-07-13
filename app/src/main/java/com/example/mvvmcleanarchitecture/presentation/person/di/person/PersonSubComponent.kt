package com.example.mvvmcleanarchitecture.presentation.person.di.person

import com.example.mvvmcleanarchitecture.presentation.person.PersonActivity
import dagger.Subcomponent

@PersonScope
@Subcomponent (modules = [PersonModule::class])
interface PersonSubComponent {
fun inject(personActivity: PersonActivity)
@Subcomponent.Factory
interface Factory{
    fun create():PersonSubComponent

}
}