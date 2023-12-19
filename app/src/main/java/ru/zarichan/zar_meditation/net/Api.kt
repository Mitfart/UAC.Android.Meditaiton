package ru.zarichan.zar_meditation.net

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("/user/login")
    fun getAuth(@Body hashMap: HashMap<String, String>): Call<Login>

    @GET("feels")
    fun getFeels(): Call<NetFeels>

    @GET("feels")
    fun getQuotes(): Call<NetQuotes>
}