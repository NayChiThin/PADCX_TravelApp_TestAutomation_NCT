package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.TourModel
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.MockTourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.models.impls.TourModelImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.data.vos.TourVO
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.dummy.getDummyTours
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.presenters.HomePresenterImpl
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.mvp.views.HomeView
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
class HomePresenterImplTest {
    private lateinit var mPresenter: HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView : HomeView
    private lateinit var mTourModel :TourModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)
        TourModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mTourModel = MockTourModelImpl
        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTourModel = this.mTourModel
    }

    @Test
    fun onTapTour_callNavigateToTourDetail(){
        val tappedTour = TourVO()
        tappedTour.name = "Mountain Trip"
        tappedTour.description = "Hiking trip"
        tappedTour.location = "Japan"
        tappedTour.averageRating = 4.0f
        mPresenter.onTapTourItem(tappedTour.name)
        verify {
            mView.navigateToTourDetail(tappedTour.name)
        }
    }

    @Test
    fun onUiReady_callDisplayTourList() {
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner)
        verify {
            mView.displayTourItems(getDummyTours())
        }
    }
}