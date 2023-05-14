package com.alialbaali.app

import androidx.compose.runtime.Composable
import com.alialbaali.app.section.Intro
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.IntroStyleSheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody { App() }
}

@Composable
private fun App() {
    Style(AppStyleSheet)
    Style(IntroStyleSheet)
    Main(attrs = { classes(AppStyleSheet.Main) }) {
        Intro()
    }
}