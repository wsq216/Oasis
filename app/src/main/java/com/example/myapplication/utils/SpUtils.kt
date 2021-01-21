package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.app.MyApp


class SpUtils {
    private val sp: SharedPreferences

    init {
        sp = MyApp.instance!!.getSharedPreferences("chat", Context.MODE_PRIVATE)
    }
    /**
     * 设置数据
     * @param key
     * @param value
     */
    fun setValue(key: String?, value: Any?) {
        val editor = sp.edit()
        if (value is String) {
            editor.putString(key, value as String?)
        } else if (value is Int) {
            editor.putInt(key, (value as Int?)!!)
        } else if (value is Boolean) {
            editor.putBoolean(key, (value as Boolean?)!!)
        } else if (value is Float) {
            editor.putFloat(key, (value as Float?)!!)
        } else if (value is Long) {
            editor.putLong(key, (value as Long?)!!)
        }
        editor.commit()
    }

    fun getString(key: String?): String? {
        return sp.getString(key, "")
    }

    fun getInt(key: String?): Int {
        return sp.getInt(key, 0)
    }

    fun getBoolean(key: String?): Boolean {
        return sp.getBoolean(key, false)
    }

    fun getFloat(key: String?): Float {
        return sp.getFloat(key, 0f)
    }

    fun getLong(key: String?): Long {
        return sp.getLong(key, 0)
    }

    /**
     * 删除对应的key
     * @param key
     */
    fun remove(key: String?) {
        sp.edit().remove(key).commit()
    }

    /**
     * 删除所有
     */
    fun delete() {
        sp.edit().clear().commit()
    }

    companion object {
        var instance: SpUtils? = null
            get() {
                if (field == null) {
                    synchronized(SpUtils::class.java) {
                        if (field == null) {
                            field = SpUtils()
                        }
                    }
                }
                return field
            }
            private set
    }


}
