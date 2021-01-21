package com.example.myapplication.ui.discover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDiscoverBinding
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.viewmodel.BindDiscoverFragmentViewModel
import com.example.myapplication.viewmodel.BindHomeFragmentViewModel
import com.shop.base.BaseFragment

class DiscoverFragment (id : Int) :  BaseFragment<BindDiscoverFragmentViewModel, FragmentDiscoverBinding>(id,
    BindDiscoverFragmentViewModel::class.java) {
    companion object{
        val instance by lazy { DiscoverFragment(R.layout.fragment_discover) }
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