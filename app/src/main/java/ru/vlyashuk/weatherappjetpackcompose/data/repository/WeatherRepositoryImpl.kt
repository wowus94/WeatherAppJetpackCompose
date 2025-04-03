package ru.vlyashuk.weatherappjetpackcompose.data.repository

import ru.vlyashuk.weatherappjetpackcompose.data.mapper.toEntity
import ru.vlyashuk.weatherappjetpackcompose.data.network.api.ApiService
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.Forecast
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.Weather
import ru.vlyashuk.weatherappjetpackcompose.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return  apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }

    private companion object {

        private const val PREFIX_CITY_ID = "id:"
    }
}