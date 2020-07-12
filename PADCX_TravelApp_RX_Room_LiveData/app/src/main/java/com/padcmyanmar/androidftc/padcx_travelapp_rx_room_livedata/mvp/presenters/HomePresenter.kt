package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.delegates.TourItemDelegate
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView

interface HomePresenter : TourItemDelegate,BasePresenter<HomeView>{
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}