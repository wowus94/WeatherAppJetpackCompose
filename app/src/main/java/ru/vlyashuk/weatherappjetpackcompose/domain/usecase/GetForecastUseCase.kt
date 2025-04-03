package ru.vlyashuk.weatherappjetpackcompose.domain.usecase

import ru.vlyashuk.weatherappjetpackcompose.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(cityId: Int) = repository.getForecast(cityId)
}