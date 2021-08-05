package com.example.havadurumukotlin.API

import com.example.havadurumukotlin.model.HavaDurumu
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class HavaDurumuService {

    private val BASE_URL="https://api.collectapi.com"
    private val api= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(HavaDurumuApı::class.java)

    fun getdata(sehirisim:String): Single<HavaDurumu> {
        return api.getHava(sehirisim)
    }


}