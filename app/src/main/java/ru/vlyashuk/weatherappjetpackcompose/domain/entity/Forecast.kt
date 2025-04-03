package ru.vlyashuk.weatherappjetpackcompose.domain.entity

data class Forecast(
    val currentWeather: Weather,
    val upcoming: List<Weather>
)
