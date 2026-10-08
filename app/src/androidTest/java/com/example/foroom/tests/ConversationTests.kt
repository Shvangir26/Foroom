package com.example.foroom.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.ConversationSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.ProfileSteps
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.alternator.foroom.R as AppR

@RunWith(AndroidJUnit4::class)
@LargeTest
class ConversationTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(ForoomActivity::class.java)

    private val loginSteps = LoginSteps()
    private val chatSteps = ChatSteps()
    private val convSteps = ConversationSteps()
    private val profileSteps = ProfileSteps()

    private val userA = "UserA"
    private val passA = "Password123!"
    private val userB = "UserB"
    private val passB = "Password123!"

    @Test
    fun testScenario1_sendAndVerifyMessageInJohnWeek() {
        val chatTitle = "johnWeek"
        val messageText = "let's go for a drink ${System.currentTimeMillis() % 1000}"

        loginSteps.verifyLoginScreen()
        loginSteps.login(userA, passA)
        Thread.sleep(2000)

        chatSteps.openChat(chatTitle)
        Thread.sleep(1500)
        convSteps.verifyChatIsOpen(chatTitle)

        convSteps.sendMessage(messageText)
        Thread.sleep(1500)
        convSteps.verifyMessageVisible(messageText)

        convSteps.closeChat()
        Thread.sleep(1000)

        chatSteps.openChat(chatTitle)
        Thread.sleep(1500)
        convSteps.verifyMessageVisible(messageText)
    }

    @Test
    fun testScenario2_sendQuestionInOwnChat() {
        val chatTitle = "David Shvangiradze"
        val suffix = System.currentTimeMillis() % 1000
        val question = "Which module do you like most in the Automation Academy? $suffix"

        loginSteps.verifyLoginScreen()
        loginSteps.login(userA, passA)
        Thread.sleep(2000)

        chatSteps.openChat(chatTitle)
        Thread.sleep(1500)
        convSteps.verifyChatIsOpen(chatTitle)

        convSteps.sendMessage(question)
        Thread.sleep(1500)
        convSteps.verifyMessageVisible(question)
    }

    @Test
    fun testScenario3_continueConversation() {
        val chatTitle = "something"
        val suffix = System.currentTimeMillis() % 1000
        val greetingA = "Hello from User A! $suffix"
        val replyB = "Hello from User B! $suffix"

        loginSteps.verifyLoginScreen()
        loginSteps.login(userA, passA)
        Thread.sleep(2000)
        chatSteps.openChat(chatTitle)
        Thread.sleep(1500)

        convSteps.sendMessage(greetingA)
        Thread.sleep(1000)
        convSteps.verifyMessageVisible(greetingA)

        convSteps.sendBulkMessages("Pushing message up", 25)
        Thread.sleep(2000)

        convSteps.closeChat()
        Thread.sleep(1000)
        profileSteps.navigateToProfile()
        Thread.sleep(1000)
        onView(withId(AppR.id.signOutItem)).perform(click())
        Thread.sleep(1500)

        loginSteps.verifyLoginScreen()
        loginSteps.login(userB, passB)
        Thread.sleep(2000)
        chatSteps.openChat(chatTitle)
        Thread.sleep(1500)

        convSteps.scrollToMessage(greetingA)
        Thread.sleep(1000)
        convSteps.verifyMessageVisible(greetingA)
        convSteps.verifyMessageVisible(userA)

        convSteps.sendMessage(replyB)
        Thread.sleep(1000)
        convSteps.verifyMessageVisible(replyB)

        convSteps.closeChat()
        Thread.sleep(1000)
        profileSteps.navigateToProfile()
        Thread.sleep(1000)
        onView(withId(AppR.id.signOutItem)).perform(click())
        Thread.sleep(1500)

        loginSteps.verifyLoginScreen()
        loginSteps.login(userA, passA)
        Thread.sleep(2000)
        chatSteps.openChat(chatTitle)
        Thread.sleep(1500)

        convSteps.scrollToMessage(replyB)
        Thread.sleep(1000)
        convSteps.verifyMessageVisible(replyB)
        convSteps.verifyMessageVisible(userB)
    }
}