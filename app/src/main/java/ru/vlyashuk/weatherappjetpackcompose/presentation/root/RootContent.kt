package ru.vlyashuk.weatherappjetpackcompose.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import ru.vlyashuk.weatherappjetpackcompose.presentation.details.DetailsContent
import ru.vlyashuk.weatherappjetpackcompose.presentation.favourite.FavouriteContent
import ru.vlyashuk.weatherappjetpackcompose.presentation.search.SearchContent
import ru.vlyashuk.weatherappjetpackcompose.presentation.ui.theme.WeatherAppJetpackComposeTheme

@Composable
fun RootContent(
    component: RootComponent
) {

    WeatherAppJetpackComposeTheme {
        Children(stack = component.stack) {
            when (val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }

                is RootComponent.Child.Favourite -> {
                    FavouriteContent(component = instance.component)
                }

                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}