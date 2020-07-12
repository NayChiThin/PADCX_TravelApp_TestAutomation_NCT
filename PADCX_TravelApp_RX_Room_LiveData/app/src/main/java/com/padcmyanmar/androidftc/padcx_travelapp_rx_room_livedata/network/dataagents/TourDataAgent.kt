package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network.dataagents

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO


interface TourDataAgent {
    fun getAllTours(
        onSuccess:(CountryVO)->Unit,
        onFailure:(String)->Unit)
}