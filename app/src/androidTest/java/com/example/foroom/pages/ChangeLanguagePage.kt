package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R as AppR

class ChangeLanguagePage {

    private val buttonGeo = withId(AppR.id.languageButtonGeo)
    private val buttonEng = withId(AppR.id.languageButtonEng)

    fun selectGeorgian() {
        onView(buttonGeo).perform(click())
    }

    fun selectEnglish() {
        onView(buttonEng).perform(click())
    }
}