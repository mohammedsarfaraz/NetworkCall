package com.example.networkcall

import com.example.networkcall.Model.ApiModel
import com.example.networkcall.Model.UserDetails
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/in/apps/top-free/10/apps.json")
    suspend fun getData(): UserDetails


}