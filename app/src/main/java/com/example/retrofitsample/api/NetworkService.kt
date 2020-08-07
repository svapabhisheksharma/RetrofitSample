package com.example.retrofitsample.api


import com.example.retrofitsample.models.RandomResult
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {

    @GET("/random.json")
    fun  getValues() : Call<RandomResult>

}