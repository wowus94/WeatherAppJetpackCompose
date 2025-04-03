package ru.vlyashuk.weatherappjetpackcompose.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vlyashuk.weatherappjetpackcompose.data.local.db.FavouriteCitiesDao
import ru.vlyashuk.weatherappjetpackcompose.data.mapper.toDbModel
import ru.vlyashuk.weatherappjetpackcompose.data.mapper.toEntities
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City
import ru.vlyashuk.weatherappjetpackcompose.domain.repository.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {

    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouriteCitiesDao
        .observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) {
       favouriteCitiesDao.addToFavourite(city.toDbModel())
    }

    override suspend fun removeFromFavourite(cityId: Int) {
        favouriteCitiesDao.removeFromFavourite(cityId)
    }
}