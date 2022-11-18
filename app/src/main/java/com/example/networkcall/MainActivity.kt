package com.example.networkcall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.Adapters.MainRecyclerAdapter
import com.example.networkcall.Database.EntryDataBase
import com.example.networkcall.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var adapters: MainRecyclerAdapter
    lateinit var button :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EntryDataBase.getDatabase(context = this@MainActivity)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_1)
        button = findViewById(R.id.click_btn)
        adapters = MainRecyclerAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = adapters

        initViewModel()

           button.setOnClickListener {
               intent = Intent(applicationContext,MainActivity2::class.java)
               startActivity(intent)
           }

    }

    private fun initViewModel() {

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getRecyclereListObserver().observe(this, Observer {

            if (it!=null){
                adapters.updateData(list =it.feed.results)
            }else {

                Toast.makeText(this,ferror",Toast.LENGTH_LONG).show()

            }
        })

        viewModel.makeApiCall()

    }
}