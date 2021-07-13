package com.example.mvvmcleanarchitecture.domain.usercase

import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.example.mvvmcleanarchitecture.domain.repository.PersonRepository

class GetPersonUserCase (private  val personRepository: PersonRepository){
    suspend fun execute():List<Person>? = personRepository.getPersons()

}