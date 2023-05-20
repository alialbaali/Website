package com.alialbaali.app.util

import com.alialbaali.app.theme.style.ThemeStyleSheet
import kotlinx.dom.addClass
import kotlinx.dom.hasClass
import kotlinx.dom.removeClass
import org.w3c.dom.Document
import org.w3c.dom.get

fun Document.toggleDarkMode(isSystemInDarkMode: Boolean?): Boolean {
    val htmlElement = getElementsByTagName("html")[0]!!
    val isDarkTheme = htmlElement.hasClass(ThemeStyleSheet.DarkTheme)
    return if (isSystemInDarkMode != null) {
        if (isSystemInDarkMode) {
            htmlElement.removeClass(ThemeStyleSheet.LightTheme)
            htmlElement.addClass(ThemeStyleSheet.DarkTheme)
            true
        } else {
            htmlElement.removeClass(ThemeStyleSheet.DarkTheme)
            htmlElement.addClass(ThemeStyleSheet.LightTheme)
            false
        }
    } else {
        when {
            isDarkTheme -> {
                htmlElement.removeClass(ThemeStyleSheet.DarkTheme)
                htmlElement.addClass(ThemeStyleSheet.LightTheme)
                false
            }

            else -> {
                htmlElement.removeClass(ThemeStyleSheet.LightTheme)
                htmlElement.addClass(ThemeStyleSheet.DarkTheme)
                true
            }
        }
    }
}