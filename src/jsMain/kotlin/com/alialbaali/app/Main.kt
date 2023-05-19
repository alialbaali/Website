package com.alialbaali.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.alialbaali.app.nav.Navbar
import com.alialbaali.app.section.*
import com.alialbaali.app.theme.style.*
import com.alialbaali.app.util.isSystemInDarkMode
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.addClass
import kotlinx.dom.removeClass
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody
import org.w3c.dom.get

fun main() {
    renderComposableInBody { App() }
}

@Composable
private fun App() {
    Styles.forEach { Style(it) }
    ThemeEffect()
    Navbar()
    Main(attrs = { classes(AppStyleSheet.Main) }) {
        Intro()
        About()
        Skills()
        Portfolio()
        Footer()
    }
}

@Composable
private fun ThemeEffect() {
    val isDarkMode = window.isSystemInDarkMode()
    LaunchedEffect(isDarkMode) {
        val htmlElement = document.getElementsByTagName("html")[0]!!
        if (isDarkMode) {
            htmlElement.removeClass(ThemeStyleSheet.LightTheme)
            htmlElement.addClass(ThemeStyleSheet.DarkTheme)
        } else {
            htmlElement.removeClass(ThemeStyleSheet.DarkTheme)
            htmlElement.addClass(ThemeStyleSheet.LightTheme)
        }
    }
}

private val Styles = listOf(
    ThemeStyleSheet,
    AppStyleSheet,
    ComponentsStyleSheet,
    IntroStyleSheet,
    AboutStyleSheet,
    SkillsStyleSheet,
    PortfolioStyleSheet,
    NavStyleSheet,
    FooterStyleSheet,
)