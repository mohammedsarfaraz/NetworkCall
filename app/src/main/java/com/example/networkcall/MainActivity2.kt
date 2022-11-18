package com.example.networkcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.Adapters.RecyclerViewAdapter
import com.example.networkcall.Database.EntryDataBase
import com.example.networkcall.Model.ApiModel
import com.example.networkcall.ViewModel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView=findViewById<RecyclerView>(R.id.recylvvein)


            Log.i("testing",EntryDataBase.getDatabase(context = applicationContext).entryDao().fetchAllData().toString())


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter

        initViewModel()
    }

    private fun initViewModel() {

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)



        viewModel.getRecyclereListObserver().observe(this,{
            list ->
            recyclerAdapter.setUpdateData(items = list)
        })
    }
}