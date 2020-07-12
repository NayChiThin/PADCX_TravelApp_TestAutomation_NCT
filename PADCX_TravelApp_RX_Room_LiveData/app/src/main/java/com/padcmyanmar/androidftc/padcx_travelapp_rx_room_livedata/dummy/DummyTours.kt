package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy

import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

fun getDummyTours() : List<TourVO> {
    val tourOne = TourVO()
    tourOne.name = "Canada Trip"
    tourOne.description = "Happy Trip to Canada"
    tourOne.averageRating = 4.2f
    tourOne.location = "Canada"
    tourOne.photos = arrayListOf()
    tourOne.scoresAndReviews = arrayListOf()


    val tourTwo = TourVO()
    tourTwo.name = "Mountain Trip"
    tourTwo.description = "Happy Trip to Canada"
    tourTwo.averageRating = 4.2f
    tourTwo.location = "Canada"
    tourTwo.photos = arrayListOf()
    tourTwo.scoresAndReviews = arrayListOf()


    val tourThree = TourVO()
    tourThree.name = "Sea Trip"
    tourThree.description = "Happy Trip to Canada"
    tourThree.averageRating = 4.2f
    tourThree.location = "Canada"
    tourThree.photos = arrayListOf()
    tourThree.scoresAndReviews = arrayListOf()

    return arrayListOf(tourOne,tourTwo,tourThree)

}