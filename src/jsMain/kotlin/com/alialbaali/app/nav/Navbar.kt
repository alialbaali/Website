package com.alialbaali.app.nav

import androidx.compose.runtime.*
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.*
import com.alialbaali.app.util.isVisible
import com.alialbaali.app.util.scrollToSection
import com.alialbaali.app.util.scrollToTop
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.get

@Composable
fun Navbar() {
    val sections = remember { Section.values().toList() }
    var currentSection by remember { mutableStateOf<Section?>(null) }
    CurrentSectionEffect { currentSection = it }
    Header(attrs = { classes(NavStyleSheet.Header) }) {
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
                        classes(AppStyleSheet.BaseButton, AppStyleSheet.TextButton)
                        onClick { window.scrollToSection(section) }
                        style { if (section == currentSection) AppStyleSheet.apply { TextButtonHoverStyle() } }
                    }
                ) {
                    Text(section.name)
                }
            }
        }
    }
}

@Composable
private fun CurrentSectionEffect(setSection: (Section?) -> Unit) {
    DisposableEffect(Unit) {
        val about = document.body!!.getElementsByClassName(AboutStyleSheet.Section)[0]!!
        val skills = document.body!!.getElementsByClassName(SkillsStyleSheet.Section)[0]!!
        val portfolio = document.body!!.getElementsByClassName(PortfolioStyleSheet.Section)[0]!!
        document.onscroll = {
            when {
                about.isVisible && !skills.isVisible -> Section.About
                skills.isVisible && !portfolio.isVisible -> Section.Skills
                portfolio.isVisible -> Section.Portfolio
                else -> null
            }.also(setSection)
        }
        onDispose { document.onscroll = null }
    }
}