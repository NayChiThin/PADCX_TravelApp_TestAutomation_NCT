package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.ScoresAndReviewsVO

class ScoresAndReviewListTypeConverter {
    @TypeConverter
    fun toString(reviewList:ArrayList<ScoresAndReviewsVO>):String {
        return Gson().toJson(reviewList)
    }
    @TypeConverter
    fun toReviewList(reviewListJsonString:String):ArrayList<ScoresAndReviewsVO> {
        val reviewListType = object :TypeToken<ArrayList<ScoresAndReviewsVO>>(){}.type
        return Gson().fromJson(reviewListJsonString,reviewListType)
    }
}