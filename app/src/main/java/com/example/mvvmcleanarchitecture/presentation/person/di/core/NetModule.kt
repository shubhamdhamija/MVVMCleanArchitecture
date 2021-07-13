package com.example.mvvmcleanarchitecture.presentation.person.di.core

import com.example.mvvmcleanarchitecture.data.api.MVVMService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private  val baseUrl:String) {

    @Singleton
    @Provides
fun providesMVVMService(retrofit: Retrofit):MVVMService{
    return retrofit.create(MVVMService::class.java)
}
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }



}
