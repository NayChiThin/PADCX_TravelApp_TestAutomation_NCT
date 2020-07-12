package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.BaseViewHolder


abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {
    var mData: MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }
    fun setNewData(data:MutableList<W>) {
        mData = data
        notifyDataSetChanged()
    }
    fun appendNewData(data:List<W>) {
        mData.addAll(data)

        notifyDataSetChanged()
    }

}