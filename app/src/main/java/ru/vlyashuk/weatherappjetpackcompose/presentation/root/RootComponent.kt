package ru.vlyashuk.weatherappjetpackcompose.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.vlyashuk.weatherappjetpackcompose.presentation.details.DetailsComponent
import ru.vlyashuk.weatherappjetpackcompose.presentation.favourite.FavouriteComponent
import ru.vlyashuk.weatherappjetpackcompose.presentation.search.SearchComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        data class Favourite(val component: FavouriteComponent) : Child

        data class Search(val component: SearchComponent) : Child

        data class Details(val component: DetailsComponent) : Child
    }
}