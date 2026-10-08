package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.RegistrationSteps
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginAndRegistrationTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java)

    private val loginSteps = LoginSteps()
    private val registrationSteps = RegistrationSteps()

    @Test
    fun testValidUsernameAndInvalidPassword() {
        val validUser = "testUser1"
        val invalidPassword = "WrongPassword123!"

        loginSteps.verifyLoginScreen()
        loginSteps.login(validUser, invalidPassword)

        Thread.sleep(2000)
        loginSteps.verifyPasswordError()
    }

    @Test
    fun testInvalidUsernameAndInvalidPassword() {
        val nonExistentUser = "user_${System.currentTimeMillis()}"
        val invalidPassword = "WrongPassword123!"

        loginSteps.verifyLoginScreen()
        loginSteps.login(nonExistentUser, invalidPassword)

        Thread.sleep(2000)
        loginSteps.verifyUsernameError()
        loginSteps.verifyPasswordError()
    }

    @Test
    fun testSuccessfulRegistration() {
        val uniqueUser = "user_${System.currentTimeMillis()}"
        val validPassword = "Password123!"

        loginSteps.verifyLoginScreen()
        loginSteps.navigateToRegistration()

        Thread.sleep(1500)
        registrationSteps.verifyRegistrationScreen()
        registrationSteps.completeRegistration(uniqueUser, validPassword, avatarIndex = 0)

        Thread.sleep(3500)
        registrationSteps.verifyHomeScreen()
    }
}