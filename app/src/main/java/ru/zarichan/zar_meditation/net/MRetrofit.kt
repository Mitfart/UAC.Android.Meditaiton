package ru.zarichan.zar_meditation.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MRetrofit {
    fun get(): Retrofit = Retrofit.Builder()
        .baseUrl("http://mskko2021.mad.hakta.pro/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}