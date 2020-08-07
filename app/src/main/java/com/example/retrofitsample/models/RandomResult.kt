package com.example.retrofitsample.models

import com.google.gson.annotations.SerializedName

data class RandomResult (
    @SerializedName("id")   val id:String,
    @SerializedName("text")   val text:String,
    @SerializedName("source")   val source:String,
    @SerializedName("source_url")   val source_url:String,
    @SerializedName("language")   val language:String,
    @SerializedName("permalink")   var permalink:String
)