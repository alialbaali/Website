package com.alialbaali.app.nav

import androidx.compose.runtime.*
import com.alialbaali.app.components.ThemeToggle
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.theme.style.*
import com.alialbaali.app.util.*
import kotlinx.browser.window
import org.jetbrains.compose.web.css.textDecorationColor
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.get

private const val ScrollPercentageThreshold = 1

@Composable
fun Navbar() {
    val sections = remember { Section.values().toList() }
    var visibleSection by remember { mutableStateOf<Section?>(null) }
    var isElevated by remember { mutableStateOf(false) }
    VisibleSectionEffect { visibleSection = it }
    window.OnScrollEffect { isElevated = window.scrollPercentage > ScrollPercentageThreshold }
    Header(
        attrs = {
            classes(NavStyleSheet.Header)
            style { if (isElevated) NavStyleSheet.apply { ElevatedNavbarStyle() } }
        }
    ) {
        A(
            attrs = {
                classes(NavStyleSheet.PageTitle)
                onClick { window.scrollToTop() }
            }
        ) {
            Text(Strings.Username)
        }
        Nav(attrs = { classes(NavStyleSheet.Nav) }) {
            sections.forEach { section ->
                A(
                    attrs = {
                        classes(ComponentsStyleSheet.TextButton, ComponentsStyleSheet.PrimaryButton)
                        onClick { window.scrollToSection(section) }
                        style { if (section == visibleSection) textDecorationColor(Variables.Colors.Primary.value()) }
                    }
                ) {
                    Text(section.name)
                }
            }
            ThemeToggle()
        }
    }
}

@Composable
private fun VisibleSectionEffect(callback: (Section?) -> Unit) {
    DisposableEffect(Unit) {
        val about = window.document.body!!.getElementsByClassName(AboutStyleSheet.Section)[0]!!
        val skills = window.document.body!!.getElementsByClassName(SkillsStyleSheet.Section)[0]!!
        val portfolio = window.document.body!!.getElementsByClassName(PortfolioStyleSheet.Section)[0]!!
        window.document.onscroll = {
            val visibleSection = when {
                about.isPartiallyVisible -> Section.About
                skills.isPartiallyVisible -> Section.Skills
                portfolio.isPartiallyVisible -> Section.Portfolio
                else -> null
            }
            callback(visibleSection)
        }
        onDispose { window.document.onscroll = null }
    }
}