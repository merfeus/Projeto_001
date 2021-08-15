package com.example.projeto001.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitUser = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userInstanceService(): ServiceUser {
        return retrofitUser.create(ServiceUser::class.java)
    }

    private val retrofitProduct = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getProductsServices(): ServiceProduct {
        return retrofitProduct.create(ServiceProduct::class.java)

    }

}