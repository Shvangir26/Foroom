package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import com.alternator.foroom.R as AppR
import com.example.design_system.R as DsR

class CreateChatPage {

    private val chatNameInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.chatNameInput))
    )

    private val chatImageChooser = withId(AppR.id.chatImageChooser)
    private val createChatBtn = withId(AppR.id.createChatButton)

    fun enterChatName(name: String): CreateChatPage {
        onView(chatNameInput).perform(typeText(name), closeSoftKeyboard())
        return this
    }

    fun chooseImage(): CreateChatPage {
        onView(chatImageChooser).perform(click())
        return this
    }

    fun clickCreateChat() {
        onView(createChatBtn).perform(click())
    }
}