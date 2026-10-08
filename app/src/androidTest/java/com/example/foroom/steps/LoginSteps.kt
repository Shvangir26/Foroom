package com.example.foroom.steps

import com.example.foroom.pages.LoginPage

class LoginSteps {

    private val loginPage = LoginPage()

    fun verifyLoginScreen() {
        loginPage.isDisplayed()
    }

    fun login(username: String, password: String) {
        loginPage.enterUsername(username)
            .enterPassword(password)
            .clickLogin()
    }

    fun navigateToRegistration() {
        loginPage.clickSignUp()
    }

    fun verifyPasswordError() {
        loginPage.checkPasswordError()
    }

    fun verifyUsernameError() {
        loginPage.checkUsernameError()
    }
}