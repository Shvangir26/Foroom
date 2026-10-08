package com.example.foroom.steps

import com.example.foroom.pages.ConversationPage

class ConversationSteps {

    private val page = ConversationPage()

    fun verifyChatIsOpen(title: String) {
        page.verifyConversationOpen(title)
    }

    fun sendMessage(text: String) {
        page.typeMessage(text).clickSend()
    }

    fun verifyMessageVisible(text: String) {
        page.verifyMessageIsDisplayed(text)
    }

    fun closeChat() {
        page.closeConversation()
    }

    fun scrollToMessage(text: String) {
        page.scrollToMessage(text)
    }

    fun sendBulkMessages(baseText: String, count: Int) {
        for (i in 1..count) {
            sendMessage("$baseText $i")
            Thread.sleep(150)
        }
    }
}