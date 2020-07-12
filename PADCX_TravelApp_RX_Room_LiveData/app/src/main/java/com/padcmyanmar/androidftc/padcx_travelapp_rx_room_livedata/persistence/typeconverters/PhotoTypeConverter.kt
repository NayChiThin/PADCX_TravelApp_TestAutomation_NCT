package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoTypeConverter {
    @TypeConverter
    fun toString(photoList:ArrayList<String>):String {
        return Gson().toJson(photoList)
    }
    @TypeConverter
    fun toPhotoList(photoListString:String):ArrayList<String> {
        val photoListType = object :TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(photoListString,photoListType)
    }
}