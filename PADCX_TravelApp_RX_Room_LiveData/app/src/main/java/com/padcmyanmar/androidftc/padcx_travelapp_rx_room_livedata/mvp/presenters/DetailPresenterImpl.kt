package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {
    var mTourModel : TourModel =
        TourModelImpl
    override fun onTourDetailUiReady(tourName: String, lifecycleOwner: LifecycleOwner) {
        tourName.let {
            mTourModel.getToursByName(it)
                .observe(lifecycleOwner, Observer {
                    if(it != null){
                        mView?.displayTourDetail(it)
                    }
                })
        }
    }

    override fun onCountryDetailUiReady(countryName: String, lifecycleOwner: LifecycleOwner) {
        countryName.let{
            mTourModel.getCountryByName(it)
                .observe(lifecycleOwner, Observer {
                    if(it!=null){
                        mView?.displayCountryDetail(it)
                    }
                })
        }
    }

    override fun onTapBackButton() {
        mView?.navigateToHome()
    }

}