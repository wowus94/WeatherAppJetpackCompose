package ru.vlyashuk.weatherappjetpackcompose.presentation.favourite

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vlyashuk.weatherappjetpackcompose.domain.entity.City
import ru.vlyashuk.weatherappjetpackcompose.presentation.extensions.componentScope

class DefaultFavouriteComponent @AssistedInject constructor(
    private val favouriteStoreFactory: FavouriteStoreFactory,
    @Assisted("onItemClicked") private val onItemClicked: (City) -> Unit,
    @Assisted("onAddFavoriteClicked") private val onAddFavoriteClicked: () -> Unit,
    @Assisted("onSearchClicked") private val onSearchClicked: () -> Unit,
    @Assisted("componentContext") componentContext: ComponentContext
) : FavouriteComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore { favouriteStoreFactory.create() }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is FavouriteStore.Label.CityItemClicked -> {
                        onItemClicked(it.city)
                    }

                    FavouriteStore.Label.ClickSearch -> {
                        onAddFavoriteClicked
                    }

                    FavouriteStore.Label.ClickToFavourite -> {
                        onSearchClicked
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<FavouriteStore.State> = store.stateFlow


    override fun onClickSearch() {
        store.accept(FavouriteStore.Intent.ClickSearch)
    }

    override fun onClickAddFavourite() {
        store.accept(FavouriteStore.Intent.ClickAddToFavourite)
    }

    override fun onItemCityClick(city: City) {
        store.accept(FavouriteStore.Intent.CityItemClicked(city))
    }

    @AssistedFactory
    interface Factory {

        fun create(
            @Assisted("onItemClicked") onItemClicked: (City) -> Unit,
            @Assisted("onAddFavoriteClicked") onAddFavoriteClicked: () -> Unit,
            @Assisted("onSearchClicked") onSearchClicked: () -> Unit,
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultFavouriteComponent
    }
}