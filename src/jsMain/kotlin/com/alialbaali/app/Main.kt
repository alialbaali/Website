package com.alialbaali.app

import androidx.compose.runtime.*
import com.alialbaali.app.nav.Navbar
import com.alialbaali.app.section.*
import com.alialbaali.app.theme.*
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody { App() }
}

@Composable
private fun App() {
    Styles.forEach { Style(it) }
    var headerHeight by remember { mutableStateOf(0) }
    Navbar(onHeaderHeightChanged = { headerHeight = it })
    Main(attrs = { classes(AppStyleSheet.Main) }) {
        Intro(headerHeight)
        About()
        Skills()
        Portfolio()
        Footer()
    }
}

private val Styles = listOf(AppStyleSheet, IntroStyleSheet, AboutStyleSheet, SkillsStyleSheet, PortfolioStyleSheet, NavStyleSheet, FooterStyleSheet)