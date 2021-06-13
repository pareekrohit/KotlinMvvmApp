package com.example.kotlinappwithmvvm.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinappwithmvvm.data.network.model.Product
import com.example.kotlinappwithmvvm.databinding.RowCartoonCakeBinding
import com.example.kotlinappwithmvvm.utilities.OnRecyclerViewClick
import java.lang.Exception

class CakeListAdapter(val onRecyclerViewClick: OnRecyclerViewClick) :
    RecyclerView.Adapter<CakeListAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var list: List<Product> = listOf()


    class ViewHolder(val binding: RowCartoonCakeBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        RowCartoonCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            val model: Product = list[position]

            holder.binding.apply {
                TvCakeName.text = model.name
                Glide.with(this.root.context).load(model.image).centerCrop().into(IvCake)

                root.setOnClickListener(View.OnClickListener {
                    onRecyclerViewClick.onRecyclerItemClick(position, "")
                })
            }
        } catch (e: Exception) {

        }
    }


    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun add(list: List<Product>) {
        this.list = list
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(mList: List<Product>) {
        this.list = mList
        notifyDataSetChanged()
    }


}