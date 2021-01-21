package com.example.myapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.ui.discover.DiscoverFragment
import com.example.myapplication.ui.me.MeFragment
import com.example.myapplication.ui.message.MessageFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView() {

        var list = ArrayList<Fragment>()
        list.add(HomeFragment.instance)
        list.add(DiscoverFragment.instance)
        list.add(MessageFragment.instance)
        list.add(MeFragment.instance)

        pager.adapter = ViewPage(supportFragmentManager,list)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                resetImg()
                when(position){
                    0-> img_home.setImageResource(R.mipmap.main_nav_home_hl)
                    1-> img_discover.setImageResource(R.mipmap.main_nav_discover_hl)
                    2-> img_message.setImageResource(R.mipmap.main_nav_message_hl)
                    3-> img_mine.setImageResource(R.mipmap.main_nav_mine_hl)
                }  }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        layout_home.setOnClickListener(this)
        layout_discover.setOnClickListener(this)
        layout_more.setOnClickListener(this)
        layout_message.setOnClickListener(this)
        layout_mine.setOnClickListener(this)
    }

    class ViewPage(fragmentManager: FragmentManager, val list: List<Fragment>) :
        FragmentStatePagerAdapter(fragmentManager) {

        override fun getCount(): Int {
            return list.size
        }

        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

    }

    override fun onClick(v: View?) {
        resetImg()
        when (v!!.id) {
            R.id.layout_home -> {
                img_home.setImageResource(R.mipmap.main_nav_home_hl)
                pager.setCurrentItem(0)
            }
            R.id.layout_discover -> {
                img_discover.setImageResource(R.mipmap.main_nav_discover_hl)
                pager.setCurrentItem(1)
            }
            R.id.layout_more -> {

            }
            R.id.layout_message -> {
                img_message.setImageResource(R.mipmap.main_nav_message_hl)
                pager.setCurrentItem(2)
            }
            R.id.layout_mine -> {
                img_mine.setImageResource(R.mipmap.main_nav_mine_hl)
                pager.setCurrentItem(3)
            }
        }
    }
    private fun resetImg(){
        img_home.setImageResource(R.mipmap.main_nav_home_normal)
        img_discover.setImageResource(R.mipmap.main_nav_discover_normal)
        img_message.setImageResource(R.mipmap.main_nav_message_normal)
        img_mine.setImageResource(R.mipmap.main_nav_mine_normal)
    }
}