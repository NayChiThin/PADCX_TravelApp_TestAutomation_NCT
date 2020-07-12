package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.BaseModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryAndTourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object TourModelImpl : BaseModel(),
    TourModel {

//    private val mTheDB:TourDB = TourDB.getDBInstance(context)
    override fun getAllTours(onError: (String) -> Unit): LiveData<List<TourVO>> {
        return mTheDB.tourDao().getAllTour()
    }

    override fun getToursByName(tourName: String): LiveData<TourVO> {
        return mTheDB.tourDao().getTourByName(tourName)
    }

    override fun getCountryByName(countryName: String): LiveData<CountryVO> {
        return mTheDB.countryDao().getCountryByName(countryName)
    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        return mTheDB.countryDao().getAllCountry()
    }

    override fun getAllCountriesAndTours(onError: (String) -> Unit): Observable<CountryAndTourVO> {


        val countryObservable = mTourApi.getAllCountries().map {
            it.data?.toList()
        }
        val tourObservable = mTourApi.getAllTours().map {
            it.data?.toList()
        }
        val countryAndTourObservable =  Observable.zip<List<CountryVO>,List<TourVO>,CountryAndTourVO>(
            countryObservable,
            tourObservable,
            BiFunction{
                countries,tours ->
                // save to persistence database
                mTheDB.countryDao().insertAllCountry(countries)
                mTheDB.tourDao().insertAllTour(tours)

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

    @SuppressLint("CheckResult")
    private fun getAllTourFromApiAndSaveToDatabase(onError:(String)->Unit) {
        mTourApi
            .getAllTours()
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.tourDao().insertAllTour(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    private fun getAllCountryFromApiAndSaveToDatabase(onError: (String) -> Unit) {
        mTourApi
            .getAllCountries()
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.countryDao().insertAllCountry(it)
            },{
                onError(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
    }
}