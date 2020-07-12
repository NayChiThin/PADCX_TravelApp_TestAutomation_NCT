package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.BaseView

interface BasePresenter<T:BaseView> {
    fun initPresenter(view:T)
}