package ru.vlyashuk.weatherappjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import ru.vlyashuk.weatherappjetpackcompose.WeatherApp
import ru.vlyashuk.weatherappjetpackcompose.presentation.root.DefaultRootComponent
import ru.vlyashuk.weatherappjetpackcompose.presentation.root.RootContent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            RootContent(component = rootComponentFactory.create(defaultComponentContext()))
        }
    }
}

