package com.example.kotlinappwithmvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinappwithmvvm.data.network.model.Product
import com.example.kotlinappwithmvvm.databinding.RowCartoonCakeBinding
import java.lang.Exception

class CakeListAdapter() : RecyclerView.Adapter<CakeListAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var list: List<Product>

    class ViewHolder(binding: RowCartoonCakeBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        RowCartoonCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            val model: Product = list[position]

            holder.binding.apply {
                TvCakeName.text = model.name
                Glide.with(this.root.context).load(model.image).centerCrop().into(IvCake)
            }
        } catch (e: Exception) {

        }
    }


    override fun getItemCount(): Int = list.size

    fun add(list: List<Product>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun addAll(mList: List<Product>) {
        this.list = mList
        notifyDataSetChanged()
    }


}