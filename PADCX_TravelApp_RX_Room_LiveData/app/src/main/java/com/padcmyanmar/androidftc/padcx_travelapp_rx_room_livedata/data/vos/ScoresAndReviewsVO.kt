package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos

import com.google.gson.annotations.SerializedName

data class ScoresAndReviewsVO(
    @SerializedName("name") val name : String = "",
    @SerializedName("score") val score : Float = 0.0F,
    @SerializedName("max_score") val maxScore : Int = 0,
    @SerializedName("total_reviews") val totalReviews : Int = 0
)