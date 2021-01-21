package com.example.myapplication.ui.me

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMeBinding
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.viewmodel.BindMeFragmentViewModel
import com.shop.base.BaseFragment

class MeFragment(id : Int) : BaseFragment<BindMeFragmentViewModel,FragmentMeBinding>(id,BindMeFragmentViewModel::class.java) {
    companion object{
        val instance by lazy { MeFragment(R.layout.fragment_me) }
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