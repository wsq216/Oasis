package com.example.myapplication.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.app.Constants
import com.example.myapplication.databinding.ActivityLoginsBinding
import com.example.myapplication.utils.SpUtils
import com.example.myapplication.viewmodel.BindLoginActivityViewModel
import com.shop.base.BaseActivity
import com.shop.utils.MyMmkv
import kotlinx.android.synthetic.main.activity_logins.*

class LoginsActivity : BaseActivity<BindLoginActivityViewModel, ActivityLoginsBinding>(
    R.layout.activity_logins,
    BindLoginActivityViewModel::class.java
) {


    override fun initView() {

        btn_login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val username = input_username.text.toString()
                val password = input_pw.text.toString()
                if (username != null && password != null) {
                    var map = HashMap<String, String>()
                    map.put("username", username)
                    map.put("password", password)
                    mViewModel.login(map)
                } else {
                    Toast.makeText(this@LoginsActivity, "账号密码不为空", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun initVM() {

        mViewModel.data.observe(this, Observer {
            if (it != null) {
                val code = it.code
                if (code == 200) {
                    val token = it.token
                    SpUtils.instance!!.setValue(Constants.token,it.token)
                    MyMmkv.setValue(Constants.token,token)
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
                    finish()
                } else if (code == 601) {
                    Toast.makeText(this, "账号密码错误", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun initData() {

    }

    override fun initVariable() {

    }

}