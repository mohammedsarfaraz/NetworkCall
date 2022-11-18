package com.example.networkcall.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.Model.Entry
import com.example.networkcall.R

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items : List<Entry> = emptyList()

    fun setUpdateData(items:List<Entry>){
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textview = view.findViewById<TextView>(R.id.tb1)
        fun bind(data:Entry){
            textview.text = data.API
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }


    var limit = 150
    override fun getItemCount(): Int {
        return if (items.size < limit){
            items.size
        }else{
            limit
        }


    }
}