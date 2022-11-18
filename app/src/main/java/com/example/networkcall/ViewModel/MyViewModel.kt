package com.example.networkcall.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkcall.ApiInterface
import com.example.networkcall.Model.ApiModel
import com.example.networkcall.Model.Entry
import com.example.networkcall.Model.UserDetails
import com.example.networkcall.RetrofitEntriesInstance
import com.example.networkcall.RetrofitIInstance
import com.example.networkcall.SecondAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MyViewModel :ViewModel() {

    lateinit var recyclerData1: MutableLiveData<UserDetails>
    lateinit var recyclerData2:MutableLiveData<ApiModel>


    init {
        recyclerData1 = MutableLiveData()
        recyclerData2 = MutableLiveData()

    }

//    init {
//    }

    fun getRecyclerDataObserver1():MutableLiveData<UserDetails>{
        return recyclerData1

    }

    fun getRecyclerDataObserver2():MutableLiveData<ApiModel>{
        return recyclerData2
    }


    fun makeApiCallData(){
        CoroutineScope(Dispatchers.IO).launch {
            val retroInstance = RetrofitIInstance.getRetroInstance().create(ApiInterface::class.java)
            val retroInstance2 = RetrofitEntriesInstance.getRetroInstanceData()
                .create(SecondAPI::class.java)

            val response1 = async {
                retroInstance.getData()

            }

            val getResponse1  = response1.await()
            recyclerData1.postValue(getResponse1)

            val response2 = async {
                retroInstance2.getDatafromApi()
            }


            val getResponse2 = response2.await()
            recyclerData2.postValue(getResponse2)

        }

    }



}


