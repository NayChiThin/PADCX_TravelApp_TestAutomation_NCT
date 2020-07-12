package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters.CountryListAdapter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.adapters.PopularTourListAdapter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.HomePresenter
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.HomePresenterImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeView {

    private lateinit var mCountryAdapter: CountryListAdapter
    private lateinit var mPopularTourAdapter: PopularTourListAdapter
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    private lateinit var mPresenter : HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
//        requestData()
        mPresenter.onUiReady(this)

    }


    override fun displayTourItems(tourList: List<TourVO>) {
        mPopularTourAdapter.setNewData(tourList.toMutableList())
    }

    override fun displayCountryItems(countryList: List<CountryVO>) {
        mCountryAdapter.setNewData(countryList.toMutableList())
    }

    override fun navigateToTourDetail(name: String) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,DetailFragment(name))
            ?.commit()
    }

    private fun setUpRecyclerView() {
        mCountryAdapter = CountryListAdapter(mPresenter)
        mPopularTourAdapter = PopularTourListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = linearLayoutManager
        rvCountry.adapter = mCountryAdapter

        val linearLayoutManager1 = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPopularTours.layoutManager = linearLayoutManager1
        rvPopularTours.adapter = mPopularTourAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

/*    @SuppressLint("CheckResult")
    private fun requestData() {
       *//* mTourModel.getAllCountriesAndTours(onError = {
            Log.e("Error",it)
        }).subscribe {
            mCountryAdapter.setNewData(it.countries.toMutableList())
            mPopularTourAdapter.setNewData(it.tours.toMutableList())
        }*//*
        mTourModel.getAllTours(onError = {}).observe(this, Observer {
            mPopularTourAdapter.setNewData(it.toMutableList())
        })
        mTourModel.getAllCountries(onError = {}).observe(this, Observer {
            mCountryAdapter.setNewData(it.toMutableList())
        })
    }*/

   /* override fun onTapTourItem(name: String) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,DetailFragment(name))
            ?.commit()
    }*/


}
