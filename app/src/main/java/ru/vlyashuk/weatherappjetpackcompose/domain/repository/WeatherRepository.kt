package ru.vlyashuk.weatherappjetpackcompose.domain.repository

import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.Forecast
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast

}