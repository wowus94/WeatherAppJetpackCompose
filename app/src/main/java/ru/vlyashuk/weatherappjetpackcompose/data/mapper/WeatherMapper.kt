package ru.vlyashuk.weatherappjetpackcompose.data.mapper


import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.WeatherCurrentDto
import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.WeatherDto
import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.WeatherForecastDto
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.Forecast
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = conditionDto.text,
    conditionUrl = conditionDto.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

fun WeatherForecastDto.toEntity() = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecast.forecastDay.drop(1).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.conditionDto.text,
            conditionUrl = dayWeatherDto.conditionDto.iconUrl.correctImageUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

private fun String.correctImageUrl() = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)