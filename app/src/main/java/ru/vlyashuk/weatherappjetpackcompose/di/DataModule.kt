package ru.vlyashuk.weatherappjetpackcompose.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.vlyashuk.weatherappjetpackcompose.data.local.db.FavouriteCitiesDao
import ru.vlyashuk.weatherappjetpackcompose.data.local.db.FavouriteDataBase
import ru.vlyashuk.weatherappjetpackcompose.data.network.api.ApiFactory
import ru.vlyashuk.weatherappjetpackcompose.data.network.api.ApiService
import ru.vlyashuk.weatherappjetpackcompose.data.repository.FavouriteRepositoryImpl
import ru.vlyashuk.weatherappjetpackcompose.data.repository.SearchRepositoryImpl
import ru.vlyashuk.weatherappjetpackcompose.data.repository.WeatherRepositoryImpl
import ru.vlyashuk.weatherappjetpackcompose.domain.repository.FavouriteRepository
import ru.vlyashuk.weatherappjetpackcompose.domain.repository.SearchRepository
import ru.vlyashuk.weatherappjetpackcompose.domain.repository.WeatherRepository

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDataBase {
            return FavouriteDataBase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(dataBase: FavouriteDataBase): FavouriteCitiesDao {
            return dataBase.favouriteCitiesDao()
        }
    }
}