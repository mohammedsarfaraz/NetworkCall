package com.example.networkcall

import com.example.networkcall.Model.ApiModel
import retrofit2.http.GET

interface SecondAPI {

    @GET("entries")
    suspend fun getDatafromApi(): ApiModel
}