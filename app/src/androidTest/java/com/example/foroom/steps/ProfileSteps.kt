package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R as AppR
import com.example.foroom.pages.ProfilePage

class ProfileSteps {

    private val profilePage = ProfilePage()

    fun navigateToProfile() {
        onView(withId(AppR.id.homeNavigationProfile)).perform(click())
    }

    fun changePassword(newPassword: String) {
        profilePage.openChangePassword()
            .enterNewPassword(newPassword)
            .enterRepeatPassword(newPassword)
            .clickConfirm()
    }

    fun changeLanguageToGeo() {
        profilePage.openChangeLanguage().selectGeorgian()
    }

    fun changeLanguageToEng() {
        profilePage.openChangeLanguage().selectEnglish()
    }

    fun verifyProfileLabel(text: String) {
        profilePage.verifyLabelText(text)
    }
}