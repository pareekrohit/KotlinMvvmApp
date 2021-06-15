package com.example.kotlinappwithmvvm.ui.activity.cakeList

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.kotlinappwithmvvm.R
import com.example.kotlinappwithmvvm.data.network.Resource
import com.example.kotlinappwithmvvm.databinding.ActivityCakeListBinding
import com.example.kotlinappwithmvvm.ui.activity.BaseActivity
import com.example.kotlinappwithmvvm.ui.adapter.CakeListAdapter
import com.example.kotlinappwithmvvm.utilities.Coroutines
import com.example.kotlinappwithmvvm.utilities.OnRecyclerViewClick
import com.example.kotlinappwithmvvm.utilities.handleApiError
import com.example.kotlinappwithmvvm.utilities.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CakeListActivity : BaseActivity(), View.OnClickListener, OnRecyclerViewClick {

    private lateinit var context: Context
    private lateinit var binding: ActivityCakeListBinding
    private val viewModel: CakeListViewModel by viewModels()
    private lateinit var cakeListAdapter: CakeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCakeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this
        initView()
        initListener()
        setAdapter()
        setViewModel()
    }


    override fun initView() {
        cakeListAdapter = CakeListAdapter(this)
    }

    override fun initListener() {
        binding.btnGo.setOnClickListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setViewModel() {
        //now use above approach to instanciate view model
        /*cakeListViewModel = ViewModelProvider(this).get(CakeListViewModel::class.java)*/


        /*viewModel.cakeList.observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })*/


        viewModel.cakeList.observe(this) {
            binding.progressBar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        Toast.makeText(
                            context,
                            "List size ${it.value.products.size}",
                            Toast.LENGTH_SHORT
                        ).show()

                        if (it.value.products.isNotEmpty()) {
                            binding.TvNoDataFound.visible(false)
                            binding.rvCartoonCake.visible(true)
                            cakeListAdapter.addAll(it.value.products)

                        } else {
                            binding.TvNoDataFound.visible(true)
                            binding.rvCartoonCake.visible(false)
                        }
                    }
                }
                is Resource.Failure -> handleApiError(it) {
                    /*login again or hit login api again*/
                }
                else -> Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun setAdapter() {
        binding.rvCartoonCake.apply {
            adapter = cakeListAdapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGo -> getCakeList()
        }
    }

    private fun getCakeList() {
        binding.progressBar.visible(true)
        val id = binding.etCakeId.text.toString()
        if (id.isNotEmpty())
            viewModel.getCakeList(id)
        else
            Toast.makeText(context, "id should not be empty", Toast.LENGTH_SHORT).show()

    }

    override fun onRecyclerItemClick(pos: Int, tag: String) {
        /*viewModel.cakeList[pos]*/
    }


}