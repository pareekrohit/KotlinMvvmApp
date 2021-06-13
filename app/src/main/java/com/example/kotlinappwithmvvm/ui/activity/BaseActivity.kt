package com.example.kotlinappwithmvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun initView()
    abstract fun initListener()

}