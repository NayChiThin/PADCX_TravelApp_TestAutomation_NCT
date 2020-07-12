package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos

data class CountryAndTourVO(
    val countries : List<CountryVO> = arrayListOf(),
    val tours : List<TourVO> = arrayListOf()
)