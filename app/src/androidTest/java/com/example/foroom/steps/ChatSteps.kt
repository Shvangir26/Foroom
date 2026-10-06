package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R as AppR
import com.example.foroom.pages.ChatsPage
import com.example.foroom.pages.CreateChatPage

class ChatSteps {

    private val createChatPage = CreateChatPage()
    private val chatsPage = ChatsPage()

    fun navigateToCreateChat() {
        onView(withId(AppR.id.homeNavigationCreateChat)).perform(click())
    }

    fun createChat(chatName: String) {
        createChatPage.enterChatName(chatName)
            .chooseImage()
            .clickCreateChat()
    }

    fun verifyChatOpenedAndClose(chatName: String) {
        chatsPage.verifyActiveChatTitle(chatName)
            .clickCloseChat()
    }

    fun searchAndVerifyChat(chatName: String) {
        chatsPage.searchChat(chatName)
            .verifyChatCardInList(chatName)
    }
}