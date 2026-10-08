package com.example.foroom.steps

import com.example.foroom.pages.RegistrationPage

class RegistrationSteps {

    private val registrationPage = RegistrationPage()

    fun verifyRegistrationScreen() {
        registrationPage.isDisplayed()
    }

    fun completeRegistration(username: String, password: String, avatarIndex: Int = 0) {
        registrationPage.enterUsername(username)
            .enterPassword(password)
            .enterRepeatPassword(password)
            .selectAvatar(avatarIndex)
            .clickSignUp()
    }

    fun verifyHomeScreen() {
        registrationPage.checkHomeScreenDisplayed()
    }
}