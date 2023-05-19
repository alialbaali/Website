package com.alialbaali.app.util

import androidx.compose.runtime.*
import com.alialbaali.app.model.Section
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import com.alialbaali.app.theme.style.NavStyleSheet
import org.w3c.dom.*

private const val DarkModeQuery = "(prefers-color-scheme: dark)"

fun Window.scrollToSection(section: Section) {
    val navbarElementHeight = document.getElementsByClassName(NavStyleSheet.Header)[0]?.clientHeight ?: 0
    val sectionElement = document.getElementsByClassName(ComponentsStyleSheet.SectionName)[section.ordinal]
    val sectionElementRelativePosition = sectionElement?.getBoundingClientRect()?.top ?: 0.0
    val sectionElementActualPosition = pageYOffset + sectionElementRelativePosition - navbarElementHeight
    val scrollOptions = ScrollToOptions(top = sectionElementActualPosition, behavior = ScrollBehavior.SMOOTH)
    window.scrollTo(scrollOptions)
}

fun Window.scrollToTop() {
    scroll(
        ScrollToOptions(
            top = 0.0,
            behavior = ScrollBehavior.SMOOTH
        )
    )
}

@Composable
fun Window.isSystemInDarkMode(): Boolean {
    var isSystemInDarkMode by remember { mutableStateOf(false) }
    val mediaQueryList = this.matchMedia(DarkModeQuery)
    DisposableEffect(Unit) {
        mediaQueryList.onchange = { isSystemInDarkMode = mediaQueryList.matches; Unit }
        onDispose { mediaQueryList.onchange = null }
    }
    return isSystemInDarkMode
}