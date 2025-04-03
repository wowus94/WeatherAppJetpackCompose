package ru.vlyashuk.weatherappjetpackcompose.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.vlyashuk.weatherappjetpackcompose.data.network.api.ApiFactory
import ru.vlyashuk.weatherappjetpackcompose.data.network.api.ApiService
import ru.vlyashuk.weatherappjetpackcompose.presentation.ui.theme.WeatherAppJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiService = ApiFactory.apiService

        CoroutineScope(Dispatchers.Main).launch {
            val currentWeather = apiService.loadCurrentWeather("London")
            val forecast = apiService.loadForecast("London")
            val cities = apiService.searchCity("London")
            Log.i("TEST", "$currentWeather\n$forecast\n$cities")
        }

        setContent {
            WeatherAppJetpackComposeTheme {

            }
        }
    }
}

