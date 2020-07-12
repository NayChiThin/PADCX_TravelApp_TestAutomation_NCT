package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView:View)
    :RecyclerView.ViewHolder(itemView){
    var mData : T? = null

    abstract fun bindData(data:T)
    abstract fun bindImage(image:String)
}