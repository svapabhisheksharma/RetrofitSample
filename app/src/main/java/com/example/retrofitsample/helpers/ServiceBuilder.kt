package com.example.retrofitsample.helpers

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceBuilder {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
                        .baseUrl("https://uselessfacts.jsph.pl/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client).build()

    fun<T> buildService(service:Class<T>): T{
        return  retrofit.create(service)
    }
}