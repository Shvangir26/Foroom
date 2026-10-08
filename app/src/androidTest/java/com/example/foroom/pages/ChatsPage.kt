package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import com.alternator.foroom.R as AppR
import com.example.design_system.R as DsR

class ChatsPage {

    private val closeButton = withId(AppR.id.closeButton)
    private val chatsRecycler = withId(AppR.id.chatsRecyclerView)

    private val searchChatInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.searchChatInput))
    )

    fun verifyActiveChatTitle(expectedName: String): ChatsPage {
        onView(allOf(withId(DsR.id.chatTitleTextView), withText(expectedName)))
            .check(matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun clickCloseChat() {
        onView(closeButton).perform(click())
    }

    fun searchChat(chatName: String): ChatsPage {
        onView(searchChatInput).perform(typeText(chatName), closeSoftKeyboard())
        return this
    }

    fun verifyChatCardInList(chatName: String) {
        onView(allOf(withId(AppR.id.chatsRecyclerView), hasDescendant(withText(chatName))))
            .check(matches(ViewMatchers.isDisplayed()))
    }
    fun openChatByName(chatName: String) {
        onView(withText(chatName)).perform(click())
    }
}
