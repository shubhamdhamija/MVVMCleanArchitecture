package com.example.mvvmcleanarchitecture.data.model.person


import com.example.mvvmcleanarchitecture.data.model.person.Person
import com.google.gson.annotations.SerializedName

data class PersonList(

    @SerializedName("results")
    val people: List<Person>,



    )
