package com.alialbaali.app.util

import androidx.compose.runtime.*
import com.alialbaali.app.model.Section
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.style.NavStyleSheet
import com.alialbaali.app.style.ThemeStyleSheet
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Theme
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

val Window.themeStatus: Theme.Status
    @Composable
    get() {
        val mediaQueryList = this.matchMedia(DarkModeQuery)
        var status by remember { mutableStateOf(mediaQueryList.matches.toThemeStatus()) }
        DisposableEffect(Unit) {
            mediaQueryList.onchange = { status = mediaQueryList.matches.toThemeStatus(); Unit }
            onDispose { mediaQueryList.onchange = null }
        }
        return status
    }

fun Window.initTheme(status: Theme.Status) {
    val htmlElement = document.getElementsByTagName("html")[0]!!
    when (status) {
        Theme.Status.Light -> {
            htmlElement.removeClass(ThemeStyleSheet.DarkTheme)
            htmlElement.addClass(ThemeStyleSheet.LightTheme)
        }

        Theme.Status.Dark -> {
            htmlElement.removeClass(ThemeStyleSheet.LightTheme)
            htmlElement.addClass(ThemeStyleSheet.DarkTheme)
        }
    }
}

fun Window.toggleThemeStatus() {
    val htmlElement = document.getElementsByTagName("html")[0]!!
    val themeStatus = htmlElement.hasClass(ThemeStyleSheet.DarkTheme).toThemeStatus()
    when (themeStatus) {
        Theme.Status.Light -> {
            htmlElement.removeClass(ThemeStyleSheet.LightTheme)
            htmlElement.addClass(ThemeStyleSheet.DarkTheme)
        }

        Theme.Status.Dark -> {
            htmlElement.removeClass(ThemeStyleSheet.DarkTheme)
            htmlElement.addClass(ThemeStyleSheet.LightTheme)
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

private fun Boolean.toThemeStatus() = if (this) Theme.Status.Dark else Theme.Status.Light