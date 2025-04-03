package ru.vlyashuk.weatherappjetpackcompose.data.mapper

import ru.vlyashuk.weatherappjetpackcompose.data.local.model.CityDbModel
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(
    id,
    name,
    country
)

fun CityDbModel.toEntity(): City = City(
    id,
    name,
    country
)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }