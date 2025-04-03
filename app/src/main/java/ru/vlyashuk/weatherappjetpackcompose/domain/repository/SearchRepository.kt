package ru.vlyashuk.weatherappjetpackcompose.domain.repository

import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}