package ru.vlyashuk.weatherappjetpackcompose.data.mapper

import ru.vlyashuk.weatherappjetpackcompose.data.network.dto.CityDto
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City

fun CityDto.toEntity(): City = City(
    id,
    name,
    country
)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }