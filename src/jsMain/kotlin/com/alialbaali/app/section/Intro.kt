package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.IntroStyleSheet
import com.alialbaali.app.util.scrollToSection
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun Intro() {
    Section(attrs = { classes(IntroStyleSheet.Section) }) {
        Span(attrs = { classes(IntroStyleSheet.Hello) }) { Text(Strings.Hello) }
        Span(attrs = { classes(IntroStyleSheet.WhoAmI) }) { Text(Strings.WhoAmI) }
        Span(attrs = { classes(IntroStyleSheet.WhatDoIDo) }) { Text(Strings.WhatDoIDo) }
        Div(attrs = { classes(IntroStyleSheet.ButtonsContainer) }) {
            Button(
                attrs = {
                    classes(AppStyleSheet.BaseButton, AppStyleSheet.FilledButton)
                    onClick { window.open(Links.Mail) }
                }
            ) {
                Text(Strings.Contact)
            }
            Button(
                attrs = {
                    classes(AppStyleSheet.BaseButton, AppStyleSheet.OutlinedButton)
                    onClick { window.scrollToSection(Section.Portfolio) }
                }
            ) {
                Text(Strings.ViewPortfolio)
            }
        }
    }
}