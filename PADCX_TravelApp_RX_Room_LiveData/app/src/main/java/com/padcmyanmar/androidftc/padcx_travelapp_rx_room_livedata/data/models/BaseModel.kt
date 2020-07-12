package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models

import android.content.Context
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network.TourApi
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network.dataagents.TourDataAgent
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db.TourDB
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    lateinit var mTourApi : TourApi
    lateinit var mTheDB: TourDB
    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mTourApi = retrofit.create(TourApi::class.java)
    }
    fun initDatabase(context: Context){
        mTheDB = TourDB.getDBInstance(context)
    }
}