package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.uitests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.activities.MainActivity
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.fragments.HomeFragment
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.views.viewholder.CountryViewHolder
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToCountryDetailsTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
    }
    @Test
    fun tapOnCountry_navigateToCountryDetails() {
        activityTestRule.activity.supportFragmentManager.beginTransaction()
            .add(R.id.flBottomNavigationContainer,HomeFragment())
        onView(withId(R.id.rvCountry))
            .perform(RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0,click()))
        onView(withId(R.id.ivCollapsingToolbar))
            .check(matches(isDisplayed()))
    }
}