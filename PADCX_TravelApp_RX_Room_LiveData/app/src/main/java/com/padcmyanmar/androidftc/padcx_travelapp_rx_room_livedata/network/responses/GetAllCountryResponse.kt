package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.utils.CODE_RESPONSE_OK

data class GetAllCountryResponse(
@SerializedName("code") val code : Int = 0,
@SerializedName("message") val message : String = "",
@SerializedName("data") val data : ArrayList<CountryVO>? = null
){
    fun isResponseOk():Boolean = (data!=null) && (code== CODE_RESPONSE_OK)
}