package com.alialbaali.app.nav

import androidx.compose.runtime.*
import com.alialbaali.app.components.ThemeToggle
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.style.*
import com.alialbaali.app.util.isPartiallyVisible
import com.alialbaali.app.util.scrollPercentage
import com.alialbaali.app.util.scrollToSection
import com.alialbaali.app.util.scrollToTop
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.get

private const val ScrollPercentageThreshold = 1

@Composable
fun Navbar() {
    val sections = remember { Section.values().toList() }
    var currentSection by remember { mutableStateOf<Section?>(null) }
    var isElevated by remember { mutableStateOf(false) }
    OnScrollEffect(setSection = { currentSection = it }, setIsElevated = { isElevated = it })
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
                        classes(ComponentsStyleSheet.BaseButton, ComponentsStyleSheet.TextButton)
                        onClick { window.scrollToSection(section) }
                        style { if (section == currentSection) ComponentsStyleSheet.apply { TextButtonHoverStyle() } }
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
private fun OnScrollEffect(setSection: (Section?) -> Unit, setIsElevated: (Boolean) -> Unit) {
    DisposableEffect(Unit) {
        val about = document.body!!.getElementsByClassName(AboutStyleSheet.Section)[0]!!
        val skills = document.body!!.getElementsByClassName(SkillsStyleSheet.Section)[0]!!
        val portfolio = document.body!!.getElementsByClassName(PortfolioStyleSheet.Section)[0]!!
        document.onscroll = {
            when {
                about.isPartiallyVisible -> Section.About
                skills.isPartiallyVisible -> Section.Skills
                portfolio.isPartiallyVisible -> Section.Portfolio
                else -> null
            }.also(setSection)
            setIsElevated(window.scrollPercentage > ScrollPercentageThreshold)
        }
        onDispose { document.onscroll = null }
    }
}