package com.example.foroom.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.alternator.foroom.R as AppR
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.ProfileSteps
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ProfileAndChatTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java)

    private val loginSteps = LoginSteps()
    private val profileSteps = ProfileSteps()
    private val chatSteps = ChatSteps()

    // გამოიყენე ემულატორზე წინასწარ რეგისტრირებული ექაუნთი
    private val testUser = "student_test"
    private val currentPass = "Password123!"
    private val newPass = "NewPass123!"

    @Test
    fun testScenario1_changePasswordAndVerify() {
        loginSteps.verifyLoginScreen()
        loginSteps.login(testUser, currentPass)

        Thread.sleep(1500)
        onView(withId(AppR.id.navBar)).check(matches(ViewMatchers.isDisplayed()))

        profileSteps.navigateToProfile()
        Thread.sleep(1000)
        profileSteps.changePassword(newPass)

        Thread.sleep(2000)
        loginSteps.verifyLoginScreen()
        loginSteps.login(testUser, newPass)

        Thread.sleep(1500)
        onView(withId(AppR.id.navBar)).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testScenario2_changeLanguage() {
        loginSteps.verifyLoginScreen()
        loginSteps.login(testUser, currentPass)

        Thread.sleep(1500)
        profileSteps.navigateToProfile()

        // 1. ქართული ენა
        profileSteps.changeLanguageToGeo()
        Thread.sleep(1000)
        profileSteps.verifyProfileLabel("ენის შეცვლა")

        // 2. ინგლისური ენა
        profileSteps.changeLanguageToEng()
        Thread.sleep(1000)
        profileSteps.verifyProfileLabel("Change Language")

        // 3. ისევ ქართული
        profileSteps.changeLanguageToGeo()
        Thread.sleep(1000)
        profileSteps.verifyProfileLabel("ენის შეცვლა")
    }

    @Test
    fun testScenario3_createChatAndSearch() {
        val myChatName = "David Shvangiradze ${System.currentTimeMillis() % 10000}"

        loginSteps.verifyLoginScreen()
        loginSteps.login(testUser, currentPass)

        Thread.sleep(1500)
        chatSteps.navigateToCreateChat()
        Thread.sleep(1000)

        chatSteps.createChat(myChatName)
        Thread.sleep(1500)

        chatSteps.verifyChatOpenedAndClose(myChatName)
        Thread.sleep(1000)

        chatSteps.searchAndVerifyChat(myChatName)
    }
}