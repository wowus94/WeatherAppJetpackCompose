package ru.vlyashuk.weatherappjetpackcompose.domain.entity

import java.util.Calendar

data class Weather(
    val temp: Float,
    val conditionText: String,
    val conditionUrl: String,
    val date: Calendar
)
