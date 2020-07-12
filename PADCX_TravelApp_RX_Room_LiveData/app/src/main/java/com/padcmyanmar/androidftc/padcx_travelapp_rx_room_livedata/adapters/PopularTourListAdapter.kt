package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.delegates.TourItemDelegate
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.BasePopularTourViewHolder
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.PopularTourViewHolder


class PopularTourListAdapter(delegate: TourItemDelegate) : BaseRecyclerAdapter<BasePopularTourViewHolder, TourVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePopularTourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_tours_list_item,parent,false)
        return PopularTourViewHolder(
            view,
            mDelegate
        )
    }
}