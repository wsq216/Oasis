package com.example.myapplication.ui.login

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.app.Constants
import com.example.myapplication.ui.home.HomeActivity
import com.example.myapplication.utils.SpUtils
import com.shop.utils.MyMmkv
import com.sprout.login.SexActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    private var clickableSpan: ClickableSpan? = null
    private var clickableSpan2: ClickableSpan? = null
    private var clickableSpan3: ClickableSpan? = null
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initClick()
    }

    private fun initClick() {
        tv_rest.setOnClickListener(this)
        btn_logins.setOnClickListener(this)
        btn_login.setOnClickListener(this)
    }

    private fun initView() {

        var file : File = Environment.getExternalStorageDirectory()
        videoview.setVideoPath("http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4")
//        videoview!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.login_bg))
        //播放
        videoview.start()

        //循环播放
        videoview.setOnCompletionListener {
            object : MediaPlayer.OnCompletionListener {
                override fun onCompletion(mp: MediaPlayer?) {
                    videoview.start()
                }
            }
        }

        val text = tv_text2!!.text.toString()
        tv_text1.movementMethod = LinkMovementMethod.getInstance()
        tv_text2.movementMethod = LinkMovementMethod.getInstance()

        val start: Int = text.indexOf(" ")
        val end: Int = text.indexOf("|")
        var span = SpannableStringBuilder(text)
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#FF9800")),
            start + 1,
            end,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        ) //设置EZ的背景色

        //监听
        clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                (view as? TextView)?.highlightColor = Color.TRANSPARENT//去除背景色
                Toast.makeText(this@LoginActivity, "用户协议", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) { //设置显示样式
                ds.isUnderlineText = false //不要默认下划线
                ds.isUnderlineText = false//去除下划线

            }
        }
        span.setSpan(clickableSpan, start + 1, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#FF9800")),
            end + 1,
            span.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        ) //设置EZ前景色，也就是字体颜色
        //监听
        clickableSpan2 = object : ClickableSpan() {
            override fun onClick(view: View) {
                (view as? TextView)?.highlightColor = Color.TRANSPARENT//去除背景色
                Toast.makeText(this@LoginActivity, "用户协议1", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) { //设置显示样式
                ds.isUnderlineText = false //不要默认下划线
                ds.isUnderlineText = false//去除下划线

            }
        }
        span.setSpan(clickableSpan2, end + 1, span.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        tv_text2.setText(span)

        val text2 = tv_text1!!.text.toString()
        var start2 = text2.indexOf(" ")
        var span2 = SpannableStringBuilder(text2)
        span2.setSpan(
            ForegroundColorSpan(Color.parseColor("#0099EE")),
            start2 + 1,
            span2.length,
            Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        ) //设置EZ的背景色


        //监听
        clickableSpan3 = object : ClickableSpan() {
            override fun onClick(view: View) {
                (view as? TextView)?.highlightColor = Color.TRANSPARENT//去除背景色
                Toast.makeText(this@LoginActivity, "用户协议2", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) { //设置显示样式
                ds.isUnderlineText = false //不要默认下划线
                ds.isUnderlineText = false//去除下划线

            }
        }
        span2.setSpan(clickableSpan3, start2 + 1, span2.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        tv_text1.setText(span2)

    }

    //返回重启加载
    override fun onRestart() {
        initView()
        super.onRestart()
    }

    //防止锁屏或者切出的时候，音乐在播放
    override fun onStop() {
        videoview!!.stopPlayback()
        super.onStop()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_rest -> {
                tv_phone.visibility = View.GONE
                ic_phone.visibility = View.VISIBLE
                tv_text1.visibility = View.GONE
                tv_rest.visibility = View.GONE
                btn_login.visibility = View.GONE
                btn_logins.visibility = View.VISIBLE
            }
            R.id.btn_logins -> {
                ic_pwd.visibility = View.VISIBLE
                //在最后一页执行倒计时
                //TODO            Interval操作符(有范围)：创建一个按照固定时间发射整数序列的Observable
                disposable =
                    Observable.intervalRange(0, 61, 0, 1, TimeUnit.SECONDS) //起始值，发送总数量，初始延迟，固定延迟
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()) //两种写法    1. lambda表达式写法：
                        .subscribe { aLong ->
                            val time = 60 - aLong
                            btn_logins.setBackgroundResource(R.drawable.phone_logins)
                            btn_logins.alpha = 0.5f
                            btn_logins.setText("倒计时：$time")
                            if (time == 0L) {
                                btn_logins.alpha = 1f
                                btn_logins.setBackgroundResource(R.drawable.phone_login)
                                btn_logins.setText("获取短信验证码")
                            }
                        }
            }
            R.id.btn_login -> {
                val string = MyMmkv.getString(Constants.token)
                val string1 = SpUtils.instance!!.getString(Constants.token)
                if (string1 != "") {
                    startActivity(Intent(this, SexActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginsActivity::class.java))
                }

            }
        }
    }

    //取消订阅的方法
    private fun cancelCallback() {
        if (disposable != null && !disposable!!.isDisposed()) {
            disposable!!.dispose()
        }
    }

}