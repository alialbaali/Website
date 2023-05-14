package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.IntroStyleSheet
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun Intro(headerHeight: Int) {
    Section(
        attrs = {
            classes(IntroStyleSheet.Section)
            style {
                marginTop(headerHeight.px)
            }
        }
    ) {
        Span(attrs = { classes(IntroStyleSheet.Hello) }) { Text(Strings.Hello) }
        Span(attrs = { classes(IntroStyleSheet.WhoAmI) }) { Text(Strings.WhoAmI) }
        Span(attrs = { classes(IntroStyleSheet.WhatDoIDo) }) { Text(Strings.WhatDoIDo) }
        Div(attrs = { classes(IntroStyleSheet.ButtonsContainer) }) {
            Button(attrs = { classes(AppStyleSheet.BaseButton, AppStyleSheet.FilledButton) }) { Text(Strings.Contact) }
            Button(attrs = { classes(AppStyleSheet.BaseButton, AppStyleSheet.OutlinedButton) }) { Text(Strings.ViewPortfolio) }
        }
    }
}