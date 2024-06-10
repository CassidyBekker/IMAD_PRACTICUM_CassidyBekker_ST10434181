package com.example.my_imad_practicum



import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MScreenTest {

    @Test
    fun testAddData() {
        // Launch the activity
        val scenario = ActivityScenario.launch(MScreen::class.java)

        // Input data into the fields
        onView(withId(R.id.WeekDayInput)).perform(typeText("Monday"), closeSoftKeyboard())
        onView(withId(R.id.MinTempInput)).perform(typeText("15"), closeSoftKeyboard())
        onView(withId(R.id.MaxTempInput)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.WeatherConInput)).perform(typeText("Sunny"), closeSoftKeyboard())

        // Click the Add button
        onView(withId(R.id.AddButton)).perform(click())

        // Check that the input fields are cleared
        onView(withId(R.id.WeekDayInput)).check(matches(withText("")))
        onView(withId(R.id.MinTempInput)).check(matches(withText("")))
        onView(withId(R.id.MaxTempInput)).check(matches(withText("")))
        onView(withId(R.id.WeatherConInput)).check(matches(withText("")))

        // Scenario.close() will automatically be called here to close the activity
    }

    @Test
    fun testCalculateAverage() {
        // Launch the activity
        val scenario = ActivityScenario.launch(MScreen::class.java)

        // Input data into the fields
        onView(withId(R.id.MinTempInput)).perform(typeText("15"), closeSoftKeyboard())
        onView(withId(R.id.MaxTempInput)).perform(typeText("25"), closeSoftKeyboard())

        // Click the Calculate Average button
        onView(withId(R.id.AvgButton)).perform(click())

        // Check the average output
        onView(withId(R.id.AvgOutput)).check(matches(withText("Average: 20.0")))

        // Scenario.close() will automatically be called here to close the activity
    }

    @Test
    fun testClearInputFields() {
        // Launch the activity
        val scenario = ActivityScenario.launch(MScreen::class.java)

        // Input data into the fields
        onView(withId(R.id.WeekDayInput)).perform(typeText("Monday"), closeSoftKeyboard())
        onView(withId(R.id.MinTempInput)).perform(typeText("15"), closeSoftKeyboard())
        onView(withId(R.id.MaxTempInput)).perform(typeText("25"), closeSoftKeyboard())
        onView(withId(R.id.WeatherConInput)).perform(typeText("Sunny"), closeSoftKeyboard())

        // Click the Clear button
        onView(withId(R.id.ClearButton)).perform(click())

        // Check that the input fields are cleared
        onView(withId(R.id.WeekDayInput)).check(matches(withText("")))
        onView(withId(R.id.MinTempInput)).check(matches(withText("")))
        onView(withId(R.id.MaxTempInput)).check(matches(withText("")))
        onView(withId(R.id.WeatherConInput)).check(matches(withText("")))

        // Check that the average output is cleared
        onView(withId(R.id.AvgOutput)).check(matches(withText("")))

        // Scenario.close() will automatically be called here to close the activity
    }
}

