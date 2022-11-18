package com.example.networkcall.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkcall.ApiInterface
import com.example.networkcall.Database.EntryDataBase
import com.example.networkcall.Model.UserDetails
import com.example.networkcall.RetrofitEntriesInstance
import com.example.networkcall.RetrofitIInstance
import com.example.networkcall.SecondAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() :ViewModel() {

     var recyclerListLiveData: MutableLiveData<UserDetails>
    private val datasave = EntryDataBase.INSTANCE?.entryDao()

    init {
        recyclerListLiveData = MutableLiveData()
        makeApiCallentry()
    }

    fun getRecyclereListObserver(): MutableLiveData<UserDetails> {
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch {
            val retroInstance = RetrofitIInstance.getRetroInstance().create(ApiInterface::class.java)
            try {
                val response = retroInstance.getData()
                recyclerListLiveData.postValue(response)
            }catch (e : Exception){

            }

        }
    }


    fun makeApiCallentry(){
        viewModelScope.launch{
            val retroInstance = RetrofitEntriesInstance.getRetroInstanceData().create(SecondAPI::class.java)
            try {
                val response = retroInstance.getDatafromApi()
                datasave?.deleteTable()
                datasave?.insertStudent(response.entries.subList(0,150))
            }catch (e : Exception){
            Log.i("",e.toString())
            }

        }
    }
}