package com.example.foroom.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import com.alternator.foroom.R as AppR
import com.example.design_system.R as DsR

class ChangePasswordPage {

    private val passwordInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.passwordInput))
    )

    private val repeatPasswordInput = allOf(
        withId(DsR.id.inputEditText),
        isDescendantOfA(withId(AppR.id.repeatPasswordInput))
    )

    // actionButton design_system-იდან მოდის
    private val actionButton = withId(DsR.id.actionButton)

    fun enterNewPassword(password: String): ChangePasswordPage {
        onView(passwordInput).perform(typeText(password), closeSoftKeyboard())
        return this
    }

    fun enterRepeatPassword(password: String): ChangePasswordPage {
        onView(repeatPasswordInput).perform(typeText(password), closeSoftKeyboard())
        return this
    }

    fun clickConfirm() {
        // ჯერ ცდის ID-ით დაჭერას, თუ ვერ იპოვა - ტექსტით
        try {
            onView(actionButton).perform(click())
        } catch (e: Throwable) {
            onView(anyOf(withText("Confirm"), withText("დადასტურება"), withText("შეცვლა"))).perform(click())
        }
    }
}