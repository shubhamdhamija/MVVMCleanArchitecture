package com.example.mvvmcleanarchitecture.presentation.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitecture.domain.usercase.GetPersonUserCase
import com.example.mvvmcleanarchitecture.domain.usercase.UpdatePersonsUserCase

class PersonViewModelFactory(private val getPersonUserCase: GetPersonUserCase
, private val updatePersonsUserCase: UpdatePersonsUserCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return  PersonViewModel(getPersonUserCase, updatePersonsUserCase) as T
    }
}