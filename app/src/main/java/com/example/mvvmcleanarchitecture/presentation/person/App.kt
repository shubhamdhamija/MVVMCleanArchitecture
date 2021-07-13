package com.example.mvvmcleanarchitecture.presentation.person

import android.app.Application
import com.example.mvvmcleanarchitecture.BuildConfig
import com.example.mvvmcleanarchitecture.presentation.person.di.core.*
import com.example.mvvmcleanarchitecture.presentation.person.di.injector
import com.example.mvvmcleanarchitecture.presentation.person.di.person.PersonSubComponent


class App :Application() ,injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createPersonSubComponent(): PersonSubComponent {
return  appComponent.personSubComponent().create()
    }
}