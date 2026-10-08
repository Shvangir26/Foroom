package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import com.alternator.foroom.R as AppR
import com.example.design_system.R as DsR

class LoginPage {

    private val usernameInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.userNameInput))
    )

    private val passwordInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.passwordInput))
    )

    private val loginBtn = withId(AppR.id.logInButton)
    private val signUpBtn = withId(AppR.id.signUpButton)

    private val usernameError = allOf(
        withId(DsR.id.descriptionTextView),
        isDescendantOfA(withId(AppR.id.userNameInput))
    )

    private val passwordError = allOf(
        withId(DsR.id.descriptionTextView),
        isDescendantOfA(withId(AppR.id.passwordInput))
    )

    fun isDisplayed(): LoginPage {
        onView(loginBtn).check(matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun enterUsername(username: String): LoginPage {
        onView(usernameInput).perform(typeText(username), closeSoftKeyboard())
        return this
    }

    fun enterPassword(password: String): LoginPage {
        onView(passwordInput).perform(typeText(password), closeSoftKeyboard())
        return this
    }

    fun clickLogin() {
        onView(loginBtn).perform(click())
    }

    fun clickSignUp() {
        onView(signUpBtn).perform(click())
    }

    fun checkUsernameError() {
        onView(usernameError).check(matches(ViewMatchers.isDisplayed()))
    }

    fun checkPasswordError() {
        onView(passwordError).check(matches(ViewMatchers.isDisplayed()))
    }
}