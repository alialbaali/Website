package com.alialbaali.app

import androidx.compose.runtime.Composable
import com.alialbaali.app.section.About
import com.alialbaali.app.section.Intro
import com.alialbaali.app.section.Skills
import com.alialbaali.app.theme.AboutStyleSheet
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.IntroStyleSheet
import com.alialbaali.app.theme.SkillsStyleSheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody { App() }
}

@Composable
private fun App() {
    Styles.forEach { Style(it) }
    Main(attrs = { classes(AppStyleSheet.Main) }) {
        Intro()
        About()
        Skills()
    }
}

private val Styles = listOf(AppStyleSheet, IntroStyleSheet, AboutStyleSheet, SkillsStyleSheet)