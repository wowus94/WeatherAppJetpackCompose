package ru.vlyashuk.weatherappjetpackcompose.data.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.vlyashuk.weatherappjetpackcompose.BuildConfig

object ApiFactory {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newUrl = originalRequest.url().newBuilder()
                .addQueryParameter("key", BuildConfig.WEATHER_API_KEY)
                .build()
            val newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create()
}