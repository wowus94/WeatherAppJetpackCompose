package ru.vlyashuk.weatherappjetpackcompose.domain.usecase

import ru.vlyashuk.weatherappjetpackcompose.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String) = repository.search(query)
}