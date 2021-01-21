package com.example.myapplication.ui.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDiscoverBinding
import com.example.myapplication.databinding.FragmentMessageBinding
import com.example.myapplication.viewmodel.BindDiscoverFragmentViewModel
import com.example.myapplication.viewmodel.BindMessageFragmentViewModel
import com.shop.base.BaseFragment

class MessageFragment (id : Int) :  BaseFragment<BindMessageFragmentViewModel, FragmentMessageBinding>(id,
    BindMessageFragmentViewModel::class.java) {
    companion object{
        val instance by lazy { MessageFragment(R.layout.fragment_message) }
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