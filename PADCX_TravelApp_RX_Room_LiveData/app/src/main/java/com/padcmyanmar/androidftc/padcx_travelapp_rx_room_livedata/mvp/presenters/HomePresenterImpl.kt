package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
    var mTourModel : TourModel =
        TourModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mTourModel.getAllTours(onError = {

        }).observe( lifecycleOwner, Observer {
            mView?.displayTourItems(it)
        })
        mTourModel.getAllCountries(onError = {

        }).observeForever{
            mView?.displayCountryItems(it)
        }
    }

    override fun onTapTourItem(name: String) {
        mView?.navigateToTourDetail(name)
    }
}