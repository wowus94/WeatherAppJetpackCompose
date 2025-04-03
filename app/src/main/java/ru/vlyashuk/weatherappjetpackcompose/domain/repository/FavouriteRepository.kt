package ru.vlyashuk.weatherappjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City

interface FavouriteRepository {

    val favouriteCities: Flow<City>

    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    suspend fun addToFavourite(city: City)

    suspend fun removeFromFavourite(cityId: Int)
}