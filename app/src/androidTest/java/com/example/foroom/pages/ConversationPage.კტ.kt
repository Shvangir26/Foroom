package com.example.foroom.pages

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import com.alternator.foroom.R as AppR
import com.example.design_system.R as DsR

class ConversationPage {

    private val messageInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.messageInput))
    )

    private val sendBtn = withId(AppR.id.sendMessageButton)
    private val closeBtn = withId(AppR.id.closeButton)

    fun verifyConversationOpen(title: String): ConversationPage {
        onView(allOf(withId(DsR.id.chatTitleTextView), withText(title)))
            .check(matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun typeMessage(text: String): ConversationPage {
        onView(messageInput).perform(typeText(text), closeSoftKeyboard())
        return this
    }

    fun clickSend(): ConversationPage {
        onView(sendBtn).perform(click())
        return this
    }

    fun verifyMessageIsDisplayed(text: String): ConversationPage {
        onView(allOf(withId(AppR.id.messagesRecyclerView), hasDescendant(withText(text))))
            .check(matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun closeConversation() {
        onView(closeBtn).perform(click())
    }

    fun scrollToMessage(text: String): ConversationPage {
        onView(withId(AppR.id.messagesRecyclerView))
            .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText(text))
            ))
        return this
    }
}