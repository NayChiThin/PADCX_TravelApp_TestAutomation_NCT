package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryAndTourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface TourModel {
    fun getAllTours(onError:(String)->Unit): LiveData<List<TourVO>>
    fun getToursByName(tourName:String) : LiveData<TourVO>
    fun getCountryByName(countryName:String): LiveData<CountryVO>
    fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>>
    fun getAllCountriesAndTours(onError:(String)->Unit) : Observable<CountryAndTourVO>
}