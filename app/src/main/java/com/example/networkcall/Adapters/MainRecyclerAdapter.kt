package com.example.networkcall.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networkcall.R

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.MyViewModel>() {

    var items = ArrayList<com.example.networkcall.Model.Result>()

    fun updateData(list : ArrayList<com.example.networkcall.Model.Result>){
        this.items = list
        notifyDataSetChanged()
    }

    class MyViewModel(view: View) :RecyclerView.ViewHolder(view){
        val textview = itemView.findViewById<TextView>(R.id.item_Tv)
        val img = itemView.findViewById<ImageView>(R.id.item_img)
        fun bind(data:com.example.networkcall.Model.Result){
            textview.text= data.artistName
            Glide
                .with(img.context)
                .load(data.artworkUrl100)
                .into(img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false)
        return MyViewModel(view)  }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {

        holder.bind(items.get(position))

    }

    override fun getItemCount(): Int {

        return items.size

    }


}