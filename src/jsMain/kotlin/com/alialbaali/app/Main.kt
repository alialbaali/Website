package com.alialbaali.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.alialbaali.app.nav.Navbar
import com.alialbaali.app.section.*
import com.alialbaali.app.theme.style.*
import com.alialbaali.app.util.isSystemInDarkMode
import com.alialbaali.app.util.toggleDarkMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody

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
    val isSystemInDarkMode = window.isSystemInDarkMode()
    LaunchedEffect(isSystemInDarkMode) { window.toggleDarkMode(isSystemInDarkMode) }
}

private val Styles = listOf(
    ThemeStyleSheet,
    AppStyleSheet,
    ComponentsStyleSheet,
    IntroStyleSheet,
    AboutStyleSheet,
    SkillsStyleSheet,
    PortfolioStyleSheet,
    ContactStyleSheet,
    NavStyleSheet,
    FooterStyleSheet,
)