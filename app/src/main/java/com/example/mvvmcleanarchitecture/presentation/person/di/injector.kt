package com.example.mvvmcleanarchitecture.presentation.person.di

import com.example.mvvmcleanarchitecture.presentation.person.di.person.PersonSubComponent

interface injector {

    fun createPersonSubComponent():PersonSubComponent
}