package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R as AppR

class ProfilePage {

    private val changePasswordItem = withId(AppR.id.changePasswordItem)
    private val changeLanguageItem = withId(AppR.id.changeLanguageItem)
    private val signOutItem = withId(AppR.id.signOutItem)

    fun openChangePassword(): ChangePasswordPage {
        onView(changePasswordItem).perform(click())
        return ChangePasswordPage()
    }

    fun openChangeLanguage(): ChangeLanguagePage {
        onView(changeLanguageItem).perform(click())
        return ChangeLanguagePage()
    }

    fun verifyLabelText(text: String): ProfilePage {
        onView(withText(text)).check(matches(ViewMatchers.isDisplayed()))
        return this
    }
}