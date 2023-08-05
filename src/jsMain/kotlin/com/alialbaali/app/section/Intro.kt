package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alialbaali.app.model.FAIcons
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.style.IntroStyleSheet
import com.alialbaali.app.style.ThemeStyleSheet
import com.alialbaali.app.theme.Theme
import com.alialbaali.app.util.scrollToSection
import com.alialbaali.app.util.themeStatusAsFlow
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun Intro() {
    val themeStatus by window.themeStatusAsFlow().collectAsState(Theme.Status.Light)
    val imageUrl = if (themeStatus.isDark) "images/Hello-Light.svg" else "images/Hello-Dark.svg"
    Section(attrs = { classes(IntroStyleSheet.Section) }) {
        Div(attrs = { classes(IntroStyleSheet.Container) }) {
            Div(attrs = { classes(IntroStyleSheet.TextContainer) }) {
                Div(attrs = { classes(IntroStyleSheet.IntroTextContainer) }) {
                    Span(attrs = { classes(IntroStyleSheet.Hello) }) { Text(Strings.Hello) }
                    Span(attrs = { classes(IntroStyleSheet.WhoAmI) }) { Text(Strings.WhoAmI) }
                }
                Span(attrs = { classes(IntroStyleSheet.WhatDoIDo) }) { Text(Strings.WhatDoIDo) }
            }
            Div(attrs = { classes(IntroStyleSheet.ButtonsContainer) }) {
                Button(
                    attrs = {
                        classes(ComponentsStyleSheet.FilledButton, ComponentsStyleSheet.PrimaryButton)
                        onClick { window.open(Links.Mail) }
                    }
                ) {
                    Text(Strings.Contact)
                    I(attrs = { classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Envelope) })
                }
                Button(
                    attrs = {
                        classes(ComponentsStyleSheet.OutlinedButton, ComponentsStyleSheet.PrimaryButton)
                        onClick { window.scrollToSection(Section.Portfolio) }
                    }
                ) {
                    Text(Strings.ViewPortfolio)
                    I(attrs = { classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.PersonDigging) })
                }
            }
        }
        Img(src = imageUrl, attrs = { classes(IntroStyleSheet.Image) })
    }
}