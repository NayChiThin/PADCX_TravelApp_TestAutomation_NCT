package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos.CountryDao
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos.TourDao

@Database(entities = [TourVO::class,CountryVO::class],version = 2,exportSchema = false)
abstract class TourDB : RoomDatabase(){
    companion object {
        val DB_NAME = "PADC_TOUR-X.DB"
        var dbInstance:TourDB? = null
        fun getDBInstance(context: Context):TourDB {
            when(dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context,TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance!!
        }
    }
    abstract fun tourDao():TourDao
    abstract fun countryDao():CountryDao
}