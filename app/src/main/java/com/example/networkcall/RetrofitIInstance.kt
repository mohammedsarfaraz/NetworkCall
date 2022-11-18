package com.example.networkcall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitIInstance {


    companion object  {

        val BASE_URL = "https://rss.applemarketingtools.com/api/"
//        val BaseUrl = "https://api.publicapis.org/"


        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }



}