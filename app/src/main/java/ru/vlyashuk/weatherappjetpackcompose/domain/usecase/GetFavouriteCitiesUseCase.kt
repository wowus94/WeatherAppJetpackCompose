package ru.vlyashuk.weatherappjetpackcompose.domain.usecase

import ru.vlyashuk.weatherappjetpackcompose.domain.repository.FavouriteRepository
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    operator fun invoke() = repository.favouriteCities
}