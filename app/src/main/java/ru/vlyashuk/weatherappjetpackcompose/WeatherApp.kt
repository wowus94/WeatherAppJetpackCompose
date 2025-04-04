package ru.vlyashuk.weatherappjetpackcompose

import android.app.Application
import ru.vlyashuk.weatherappjetpackcompose.di.ApplicationComponent
import ru.vlyashuk.weatherappjetpackcompose.di.DaggerApplicationComponent

class WeatherApp() : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}