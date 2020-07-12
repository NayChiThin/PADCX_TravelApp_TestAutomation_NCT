package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.BaseView

abstract class AbstractBasePresenter<T:BaseView>:BasePresenter<T>,ViewModel() {
    var mView : T? = null
    override fun initPresenter(view: T) {
        mView = view
    }
}