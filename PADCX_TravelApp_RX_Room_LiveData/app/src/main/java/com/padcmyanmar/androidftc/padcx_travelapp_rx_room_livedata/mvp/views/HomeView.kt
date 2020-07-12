package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

interface HomeView : BaseView{
    fun displayTourItems(tourList:List<TourVO>)
    fun displayCountryItems(countryList:List<CountryVO>)
    fun navigateToTourDetail(name : String)
}