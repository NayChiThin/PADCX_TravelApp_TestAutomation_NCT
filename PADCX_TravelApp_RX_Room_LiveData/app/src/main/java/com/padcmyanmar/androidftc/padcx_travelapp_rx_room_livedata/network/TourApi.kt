package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network.responses.GetAllCountryResponse
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network.responses.GetAllTourResponse
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.utils.GET_COUNTRY
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.utils.GET_TOUR
import io.reactivex.Observable
import retrofit2.http.GET

interface TourApi {
    @GET(GET_TOUR)
    fun getAllTours(): Observable<GetAllTourResponse>
    @GET(GET_COUNTRY)
    fun getAllCountries() : Observable<GetAllCountryResponse>
}