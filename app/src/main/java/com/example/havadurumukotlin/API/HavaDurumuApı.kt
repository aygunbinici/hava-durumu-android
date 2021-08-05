package com.example.havadurumukotlin.API

import com.example.havadurumukotlin.model.HavaDurumu
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HavaDurumuApı {

    @Headers("authorization: apikey 5gcvAxpcJiVKVBotAJyy8B:4RhU1vPNvWhzWvn6rNBfLr")
    @GET("/weather/getWeather")
    fun getHava(@Query("data.city") sehir:String): Single<HavaDurumu>

}