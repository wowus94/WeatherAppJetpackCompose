package ru.vlyashuk.weatherappjetpackcompose.domain.usecase

import ru.vlyashuk.weatherappjetpackcompose.domain.repository.FavouriteRepository
import javax.inject.Inject

class ObserveFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    operator fun invoke(cityId: Int) = repository.observeIsFavourite(cityId)
}