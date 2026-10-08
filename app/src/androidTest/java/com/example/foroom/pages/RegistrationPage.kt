package com.example.foroom.pages

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import com.alternator.foroom.R as AppR
import com.example.design_system.R as DsR

class RegistrationPage {

    private val usernameInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.userNameInput))
    )

    private val passwordInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.passwordInput))
    )

    private val repeatPasswordInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.repeatPasswordInput))
    )

    private val avatarListView = withId(AppR.id.listView)
    private val signUpBtn = withId(AppR.id.signUpButton)
    private val homeNavBar = withId(AppR.id.navBar)

    fun isDisplayed(): RegistrationPage {
        onView(avatarListView).check(matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun enterUsername(username: String): RegistrationPage {
        onView(usernameInput).perform(typeText(username), closeSoftKeyboard())
        return this
    }

    fun enterPassword(password: String): RegistrationPage {
        onView(passwordInput).perform(typeText(password), closeSoftKeyboard())
        return this
    }

    fun enterRepeatPassword(password: String): RegistrationPage {
        onView(repeatPasswordInput).perform(typeText(password), closeSoftKeyboard())
        return this
    }

    fun selectAvatar(position: Int = 0): RegistrationPage {
        onData(anything())
            .inAdapterView(avatarListView)
            .atPosition(position)
            .perform(click())
        return this
    }

    fun clickSignUp() {
        onView(signUpBtn).perform(click())
    }

    fun checkHomeScreenDisplayed() {
        onView(homeNavBar).check(matches(ViewMatchers.isDisplayed()))
    }
}