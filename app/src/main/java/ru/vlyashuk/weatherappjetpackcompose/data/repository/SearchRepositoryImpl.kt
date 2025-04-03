package ru.vlyashuk.weatherappjetpackcompose.data.repository

import ru.vlyashuk.weatherappjetpackcompose.data.mapper.toEntities
import ru.vlyashuk.weatherappjetpackcompose.data.network.api.ApiService
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City
import ru.vlyashuk.weatherappjetpackcompose.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}