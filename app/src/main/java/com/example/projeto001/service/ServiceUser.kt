package com.example.projeto001.service

import com.example.projeto001.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ServiceUser {

    @GET("/users")
    fun getUser(): Call<List<User>>

}