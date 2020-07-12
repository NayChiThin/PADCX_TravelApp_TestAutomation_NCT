package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO

fun getDummyCountries():List<CountryVO>{

    val tourOne = CountryVO()
    tourOne.name = "Canada Trip"
    tourOne.description = "Happy Trip to Canada"
    tourOne.averageRating = 4.2f
    tourOne.location = "Canada"
    tourOne.photos = arrayListOf()
    tourOne.scoresAndReviews = arrayListOf()


    val tourTwo = CountryVO()
    tourTwo.name = "Canada Trip"
    tourTwo.description = "Happy Trip to Canada"
    tourTwo.averageRating = 4.2f
    tourTwo.location = "Canada"
    tourTwo.photos = arrayListOf()
    tourTwo.scoresAndReviews = arrayListOf()


    val tourThree = CountryVO()
    tourThree.name = "Canada Trip"
    tourThree.description = "Happy Trip to Canada"
    tourThree.averageRating = 4.2f
    tourThree.location = "Canada"
    tourThree.photos = arrayListOf()
    tourThree.scoresAndReviews = arrayListOf()

    return arrayListOf(tourOne,tourTwo,tourThree)
}