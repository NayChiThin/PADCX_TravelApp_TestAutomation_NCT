package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos.CountryDao
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.daos.TourDao
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.persistence.db.TourDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var tourDao: TourDao
    private lateinit var countryDao: CountryDao
    private lateinit var db : TourDB

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,TourDB::class.java
        ).build()
        tourDao = db.tourDao()
        countryDao = db.countryDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        // test tour dao
        val tourOne = TourVO()
        tourOne.name = "New Tour"
        tourOne.description = "Fresh and relaxing"
        tourOne.averageRating = 4.5f
        tourOne.location = "France"
        tourOne.scoresAndReviews = arrayListOf()
        tourOne.photos = arrayListOf()
        val tourTwo = TourVO()
        tourOne.name = "New Tour Two"
        tourOne.description = "Fresh and relaxing"
        tourOne.averageRating = 4.0f
        tourOne.location = "France"
        tourOne.scoresAndReviews = arrayListOf()
        tourOne.photos = arrayListOf()
        tourDao.insertAllTour(arrayListOf(tourOne,tourTwo))
        assert(tourDao.getTourByName(tourOne.name).value?.name == tourOne.name)
        assert(tourDao.getTourByName(tourTwo.name).value?.name == tourTwo.name)
        // test country dao
        val countryOne = CountryVO()
        countryOne.name = "New Country Tour"
        countryOne.description = "Cheap"
        countryOne.averageRating = 3.9f
        countryOne.location = "France"
        countryOne.scoresAndReviews = arrayListOf()
        countryOne.photos = arrayListOf()
        val countryTwo = CountryVO()
        countryTwo.name = "New Country Tour Two"
        countryTwo.description = "Cheap"
        countryTwo.averageRating = 3.9f
        countryTwo.location = "France"
        countryTwo.scoresAndReviews = arrayListOf()
        countryTwo.photos = arrayListOf()
        assert(countryDao.getCountryByName(countryOne.name).value?.name == countryOne.name)
        assert(countryDao.getCountryByName(countryTwo.name).value?.name == countryTwo.name)
    }
}