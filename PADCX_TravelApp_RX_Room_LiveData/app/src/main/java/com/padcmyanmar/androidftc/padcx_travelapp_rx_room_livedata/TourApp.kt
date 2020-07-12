package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata

import android.app.Application
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.TourModelImpl

class TourApp : Application() {
    override fun onCreate() {
        super.onCreate()
        TourModelImpl.initDatabase(applicationContext)
    }
}