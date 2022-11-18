package com.example.networkcall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitEntriesInstance {


    companion object  {

//        val BASE_URL = "https://rss.applemarketingtools.com/api/"
        val BaseUrl = "https://api.publicapis.org/"


        fun getRetroInstanceData(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }

}