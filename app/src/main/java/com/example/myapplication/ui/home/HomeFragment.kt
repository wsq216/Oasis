package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.viewmodel.BindHomeFragmentViewModel
import com.shop.base.BaseFragment

class HomeFragment (id : Int) :  BaseFragment<BindHomeFragmentViewModel,FragmentHomeBinding>(id,BindHomeFragmentViewModel::class.java) {
        companion object{
                val instance by lazy { HomeFragment(R.layout.fragment_home) }
        }

        override fun initView() {

        }

        override fun initVM() {
        }

        override fun initData() {
        }

        override fun initVariable() {
        }

}