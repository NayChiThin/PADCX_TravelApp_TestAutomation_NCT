package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.DetailViewHolder

class DetailListAdapter(val context : Context?) : RecyclerView.Adapter<DetailViewHolder>() {
    var mImageList: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_image_list,parent,false)
        return DetailViewHolder(
            view
        )
    }

    fun setTourImage(data:List<String>) {
        mImageList.clear()
        mImageList.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mImageList.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bindImage(mImageList[position])
    }


}