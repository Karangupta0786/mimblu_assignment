package com.example.mimb.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val gson = GsonBuilder().setLenient().create()

    val retrofit =
        Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("http://dev.mimblu.com/")
        .build()
        .create(MimbluInterface::class.java)
}