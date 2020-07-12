package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.delegates.TourItemDelegate
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.CountryViewHolder


class CountryListAdapter(delegate: TourItemDelegate) :
    BaseRecyclerAdapter<CountryViewHolder, CountryVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.country_list_item,parent,false)
        return CountryViewHolder(
            view,
            mDelegate
        )
    }

}