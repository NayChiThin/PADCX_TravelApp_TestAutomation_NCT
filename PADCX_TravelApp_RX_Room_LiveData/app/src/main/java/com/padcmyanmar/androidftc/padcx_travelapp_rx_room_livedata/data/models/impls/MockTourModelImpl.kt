package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryAndTourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyCountries
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyTours
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object MockTourModelImpl: TourModel {

    var country : MutableList<CountryVO> = arrayListOf()
    var countryLiveData = MutableLiveData<List<CountryVO>>()
    var countryAndTour : MutableList<CountryAndTourVO> = arrayListOf()

    override fun getAllTours(onError: (String) -> Unit): LiveData<List<TourVO>> {
        val liveData = MutableLiveData<List<TourVO>>()
        liveData.postValue(getDummyTours())
        return liveData
    }

    override fun getToursByName(tourName: String): LiveData<TourVO> {
        val liveData = MutableLiveData<TourVO>()
        liveData.postValue(getDummyTours().first {
            it.name == tourName
        })
        return liveData
    }

    override fun getCountryByName(countryName: String): LiveData<CountryVO> {
        val liveData = MutableLiveData<CountryVO>()
        liveData.postValue(getDummyCountries().first {
            it.name == countryName
        })
        return liveData
    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        countryLiveData.postValue(country)
        return countryLiveData
    }

    override fun getAllCountriesAndTours(onError: (String) -> Unit): Observable<CountryAndTourVO> {

        val countryObservable = TourModelImpl.mTourApi.getAllCountries().map {
            it.data?.toList()
        }
        val tourObservable = TourModelImpl.mTourApi.getAllTours().map {
            it.data?.toList()
        }
        val countryAndTourObservable =  Observable.zip<List<CountryVO>,List<TourVO>,CountryAndTourVO>(
            countryObservable,
            tourObservable,
            BiFunction{
                    countries,tours ->
                // save to persistence database
                TourModelImpl.mTheDB.countryDao().insertAllCountry(countries)
                TourModelImpl.mTheDB.tourDao().insertAllTour(tours)

                val countryAndTour = CountryAndTourVO(
                    countries = countries,
                    tours = tours
                )
                return@BiFunction countryAndTour
            }
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        return countryAndTourObservable
    }

}