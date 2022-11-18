package com.example.networkcall.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkcall.ApiInterface
import com.example.networkcall.Database.EntryDataBase
import com.example.networkcall.Model.ApiModel
import com.example.networkcall.Model.Entry
import com.example.networkcall.RetrofitEntriesInstance
import com.example.networkcall.SecondAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {


    lateinit var recyclerListLiveData: LiveData<List<Entry>>
    private val datasave = EntryDataBase.INSTANCE?.entryDao()



    init {
        recyclerListLiveData = datasave?.fetchAllData()!!
    }

    fun getRecyclereListObserver():LiveData<List<Entry>>{
        return recyclerListLiveData
    }


}