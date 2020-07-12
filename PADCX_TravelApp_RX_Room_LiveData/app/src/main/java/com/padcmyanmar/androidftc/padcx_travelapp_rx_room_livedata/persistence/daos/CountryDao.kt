package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO

@Dao
interface CountryDao
{
    @Query("SELECT * FROM country")
    fun getAllCountry(): LiveData<List<CountryVO>>

    @Query("SELECT * FROM country WHERE name=:noteName")
    fun getCountryByName(noteName:String): LiveData<CountryVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountry(tour:List<CountryVO>)
}