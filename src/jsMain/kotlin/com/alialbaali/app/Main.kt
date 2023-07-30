package com.alialbaali.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.alialbaali.app.nav.Navbar
import com.alialbaali.app.section.*
import com.alialbaali.app.style.*
import com.alialbaali.app.util.StorageIds
import com.alialbaali.app.util.initTheme
import com.alialbaali.app.util.themeStatus
import com.alialbaali.app.util.toThemeStatus
import kotlinx.browser.localStorage
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
        Contact()
        Footer()
    }
}

@Composable
private fun ThemeEffect() {
    val storageStatus = localStorage.getItem(StorageIds.Theme)?.toThemeStatus()
    val windowStatus = window.themeStatus
    val state = remember(windowStatus) { storageStatus ?: windowStatus }
    LaunchedEffect(state) { window.initTheme(state) }
}

private val Styles = listOf(
    ThemeStyleSheet,
    AppStyleSheet,
    ComponentsStyleSheet,
    IntroStyleSheet,
    AboutStyleSheet,
    SkillsStyleSheet,
    PortfolioStyleSheet,
    ContactFormStyleSheet,
    NavStyleSheet,
    FooterStyleSheet,
    ContactStyleSheet,
)