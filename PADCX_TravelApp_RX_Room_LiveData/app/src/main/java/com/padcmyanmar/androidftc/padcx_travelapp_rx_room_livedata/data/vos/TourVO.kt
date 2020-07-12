package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.typeconverters.PhotoTypeConverter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.typeconverters.ScoresAndReviewListTypeConverter

@Entity(tableName = "tour")
@TypeConverters(ScoresAndReviewListTypeConverter::class,PhotoTypeConverter::class)
data class TourVO(
    @PrimaryKey
    @SerializedName("name")var name : String ="",
    @SerializedName("description") var description : String = "",
    @SerializedName("location") var location : String = "",
    @SerializedName("average_rating") var averageRating : Float = 0.0F,
    @SerializedName("scores_and_reviews") var scoresAndReviews : ArrayList<ScoresAndReviewsVO> = arrayListOf(),
    @SerializedName("photos") var photos : ArrayList<String> = arrayListOf()

)