package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import kotlinx.android.synthetic.main.detail_image_list.view.*

class DetailViewHolder(itemView: View): BaseCountryViewHolder(itemView){


    override fun bindData(data: CountryVO) {

    }

    override fun bindImage(image: String) {
        Glide.with(itemView.context)
            .load(image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(itemView.ivImage)
    }


}