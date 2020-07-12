package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

interface DetailView : BaseView {
    fun displayTourDetail(tour:TourVO)
    fun displayCountryDetail(tour:CountryVO)
    fun navigateToHome()
}