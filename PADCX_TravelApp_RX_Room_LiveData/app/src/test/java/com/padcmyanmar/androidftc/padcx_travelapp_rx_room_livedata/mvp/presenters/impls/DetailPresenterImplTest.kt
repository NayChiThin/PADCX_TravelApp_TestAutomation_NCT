package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.MockTourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.CountryVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyCountries
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyTours
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.DetailPresenterImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.DetailView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailPresenterImplTest {
    private lateinit var mPresenter :DetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView: DetailView
    private lateinit var mTourModel: TourModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)
        mTourModel = MockTourModelImpl
        mPresenter = DetailPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTourModel = this.mTourModel
    }

    @Test
    fun onBackButton_navigateToHome(){
        mPresenter.onTapBackButton()
        verify {
            mView.navigateToHome()
        }
    }

    @Test
    fun onTourUiReady_displayTourDetail(){
        val tour = getDummyTours().first()
        tour.name = "Mountain Trip"
        tour.description = "Happy Trip to Canada"
        tour.location = "Canada"
        tour.averageRating = 4.2f
        tour.photos = arrayListOf()
        tour.scoresAndReviews = arrayListOf()
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        mPresenter.onTourDetailUiReady(tour.name,lifeCycleOwner)
        verify {
            mView.displayTourDetail(tour)
        }
    }
    @Test
    fun onCountryUiReady_displayCountryDetail() {
        val country = getDummyCountries().first()
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        mPresenter.onCountryDetailUiReady(country.name,lifeCycleOwner)
        verify {
            mView.displayCountryDetail(country)
        }
    }

}