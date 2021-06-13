package com.example.kotlinappwithmvvm.ui.activity.cakeList

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinappwithmvvm.R
import com.example.kotlinappwithmvvm.data.network.model.Product
import com.example.kotlinappwithmvvm.databinding.ActivityCakeListBinding
import com.example.kotlinappwithmvvm.ui.activity.BaseActivity
import com.example.kotlinappwithmvvm.ui.adapter.CakeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CakeListActivity : BaseActivity() {

    lateinit var context: Context
    lateinit var binding: ActivityCakeListBinding
    private val viewModel: CakeListViewModel by viewModel()
    private val adapter = CakeListAdapter()

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

    }

    override fun initListener() {

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setViewModel() {
        //now use above approach to instanciate view model
        /*cakeListViewModel = ViewModelProvider(this).get(CakeListViewModel::class.java)*/

        /*lifecycleScope.launch {
            viewModel.getCakeList("2")
        }*/

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getCakeList("2")
        }



        /*viewModel.cakeList.observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })*/



/*viewModel.loginResponse?.observe(viewLifecycleOwner) {
            binding.progressbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        viewModel.saveAccessTokens(
                            it.value.user.access_token!!,
                            it.value.user.refresh_token!!
                        )
                        requireActivity().startNewActivity1(HomeActivity::class.java)
                    }
                }
                is Resource.Failure -> handleApiError(it) { login() }
            }
        }*/

    }


    private fun setAdapter() {
        binding.rvCartoonCake.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
    }

}