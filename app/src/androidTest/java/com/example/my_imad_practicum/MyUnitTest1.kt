package com.example.my_imad_practicum


import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testNextButton_opensMScreen() {
        // Launch the MainActivity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Perform click on the Next button
        onView(withId(R.id.NextButton)).perform(click())

        // Check if the new activity is displayed
        onView(withId(R.id.some_view_in_mscreen)) // Replace with an actual view ID from MScreen
            .check(matches(isDisplayed()))

        // Close the scenario
        scenario.close()
    }

    @Test
    fun testExitButton_finishesActivity() {
        // Launch the MainActivity
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Perform click on the Exit button
        onView(withId(R.id.Exitbutton)).perform(click())

        // Check if the activity is finishing
        scenario.onActivity { activity ->
            assert(activity.isFinishing)
        }

        // Close the scenario
        scenario.close()
    }
}