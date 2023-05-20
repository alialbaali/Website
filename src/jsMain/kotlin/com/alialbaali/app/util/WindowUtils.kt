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
    val mediaQueryList = this.matchMedia(DarkModeQuery)
    var isSystemInDarkMode by remember { mutableStateOf(mediaQueryList.matches) }
    DisposableEffect(Unit) {
        mediaQueryList.onchange = { isSystemInDarkMode = mediaQueryList.matches; Unit }
        onDispose { mediaQueryList.onchange = null }
    }
    return isSystemInDarkMode
}

val Window.scrollPercentage: Double
    get() {
        val scrollTop = document.documentElement?.scrollTop ?: 0.0
        val viewportHeight = document.documentElement?.clientHeight ?: 0
        val documentHeight = document.documentElement?.scrollHeight ?: 0
        return scrollTop / (documentHeight - viewportHeight) * 100
    }

@Deprecated("Use Window.scrollPercentage")
private fun Window.inaccurateScrollPercentage(): Double {
    val scrollPosition = pageYOffset
    val viewportHeight = innerHeight
    val documentHeight = document.documentElement?.scrollHeight ?: 0
    return (scrollPosition + viewportHeight) / documentHeight * 100
}