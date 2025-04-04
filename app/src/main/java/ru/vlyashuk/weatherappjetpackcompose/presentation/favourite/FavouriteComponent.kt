package ru.vlyashuk.weatherappjetpackcompose.presentation.favourite

import kotlinx.coroutines.flow.StateFlow
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City

interface FavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun onClickAddFavourite()

    fun onItemCityClick(city: City)
}