package com.alialbaali.app.util

import androidx.compose.runtime.*
import com.alialbaali.app.model.Section
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.style.NavStyleSheet
import com.alialbaali.app.style.ThemeStyleSheet
import com.alialbaali.app.theme.Dimensions
import kotlinx.dom.addClass
import kotlinx.dom.hasClass
import kotlinx.dom.removeClass
import org.jetbrains.compose.web.css.times
import org.w3c.dom.*
import org.w3c.dom.events.Event

private const val DarkModeQuery = "(prefers-color-scheme: dark)"
private const val ScrollEventType = "scroll"

private external fun parseFloat(s: String, radix: Int = definedExternally): Double

fun Window.scrollToSection(section: Section) {
    val navbarElementHeight = document.getElementsByClassName(NavStyleSheet.Header)[0]?.clientHeight ?: 0
    val sectionElement = document.getElementsByClassName(ComponentsStyleSheet.SectionName)[section.ordinal]
    val sectionElementRelativePosition = sectionElement?.getBoundingClientRect()?.top ?: 0.0
    val sectionMargin = Dimensions.SectionNameVerticalMargin * parseFloat(getComputedStyle(document.documentElement!!).fontSize)
    val sectionElementActualPosition = pageYOffset + sectionElementRelativePosition - navbarElementHeight - sectionMargin.value
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


fun Window.toggleDarkMode(isSystemInDarkMode: Boolean?): Boolean {
    val htmlElement = document.getElementsByTagName("html")[0]!!
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

@Composable
fun Window.OnScrollEffect(callback: (Event) -> Unit) {
    DisposableEffect(Unit) {
        document.addEventListener(ScrollEventType, callback)
        onDispose { document.removeEventListener(ScrollEventType, callback) }
    }
}