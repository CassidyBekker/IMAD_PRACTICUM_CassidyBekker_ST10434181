package com.example.my_imad_practicum

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailedViewTest {

    @Test
    fun testTablePopulation() {
        // Mock data to be passed to the activity
        val screenData = arrayListOf(
            ScreenDataEntry("Monday", 15, 25, "Sunny"),
            ScreenDataEntry("Tuesday", 18, 28, "Cloudy")
        )

        // Create the intent to launch the activity
        val intent = Intent(InstrumentationRegistry.getInstrumentation().targetContext, DetailedView::class.java).apply {
            putExtra("screenData", screenData)
        }

        // Launch the activity
        val scenario = ActivityScenario.launch<DetailedView>(intent)

        // Verify the header row
        onView(withText("Day")).check(matches(isDisplayed()))
        onView(withText("Min")).check(matches(isDisplayed()))
        onView(withText("Max")).check(matches(isDisplayed()))
        onView(withText("Weather-conditions")).check(matches(isDisplayed()))

        // Verify the first row of data
        onView(withText("Monday")).check(matches(isDisplayed()))
        onView(withText("15")).check(matches(isDisplayed()))
        onView(withText("25")).check(matches(isDisplayed()))
        onView(withText("Sunny")).check(matches(isDisplayed()))

        // Verify the second row of data
        onView(withText("Tuesday")).check(matches(isDisplayed()))
        onView(withText("18")).check(matches(isDisplayed()))
        onView(withText("28")).check(matches(isDisplayed()))
        onView(withText("Cloudy")).check(matches(isDisplayed()))

        // Close the activity scenario
        scenario.close()
    }
}