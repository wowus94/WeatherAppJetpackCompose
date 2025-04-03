package ru.vlyashuk.weatherappjetpackcompose.data.network.dto

import com.google.gson.annotations.SerializedName

data class WeatherForecastDto(

    @SerializedName("current") val current: WeatherDto,
    @SerializedName("forecast") val forecast: ForecastDto
)
