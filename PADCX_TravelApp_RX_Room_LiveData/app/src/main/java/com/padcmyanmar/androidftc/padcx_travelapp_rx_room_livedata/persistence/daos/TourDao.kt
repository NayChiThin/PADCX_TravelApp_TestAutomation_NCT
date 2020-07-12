package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO

@Dao
interface TourDao {
    @Query("SELECT * FROM tour")
    fun getAllTour():LiveData<List<TourVO>>

    @Query("SELECT * FROM tour WHERE name=:noteName")
    fun getTourByName(noteName:String):LiveData<TourVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTour(tour:List<TourVO>)
}