package com.shop.api



import com.example.myapplication.data.LoginData
import com.shop.net.BaseResp
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ServiceApi {

    //登录
    @POST("auth/login")
    @FormUrlEncoded
    suspend fun login(@FieldMap map: HashMap<String,String>) : BaseResp<LoginData>


}