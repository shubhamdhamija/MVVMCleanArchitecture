package com.example.mvvmcleanarchitecture.presentation.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitecture.domain.usercase.GetPersonUserCase
import com.example.mvvmcleanarchitecture.domain.usercase.UpdatePersonsUserCase

class PersonViewModel(private  val getPersonUserCase: GetPersonUserCase,
private val updatePersonsUserCase: UpdatePersonsUserCase): ViewModel() {

fun GetPersons() = liveData {
    val personList = getPersonUserCase.execute()
emit(personList)
}
    fun UpdatePersons()= liveData {
        val personList = updatePersonsUserCase.execute()
        emit(personList)
    }
    }