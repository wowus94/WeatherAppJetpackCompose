package ru.vlyashuk.weatherappjetpackcompose.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.CityDto
import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.WeatherCurrentDto
import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.WeatherForecastDto

interface ApiService {

    @GET("current.json?key=key")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto

    @GET("forecast.json?key=key")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto

    @GET("search.json?key=key")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto>
}