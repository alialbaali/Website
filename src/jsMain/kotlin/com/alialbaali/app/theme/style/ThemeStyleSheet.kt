package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Theme
import com.alialbaali.app.theme.Variables
import org.jetbrains.compose.web.css.StyleSheet

object ThemeStyleSheet : StyleSheet() {

    const val MaterialDesignIcons = "material-icons-round"

    val LightTheme by style {
        Variables.Colors.Primary(Theme.LightColors.Primary)
        Variables.Colors.OnPrimary(Theme.LightColors.OnPrimary)

        Variables.Colors.Secondary(Theme.LightColors.Secondary)
        Variables.Colors.OnSecondary(Theme.LightColors.OnSecondary)

        Variables.Colors.Surface(Theme.LightColors.Surface)
        Variables.Colors.OnSurface(Theme.LightColors.OnSurface)

        Variables.Colors.Background(Theme.LightColors.Background)
        Variables.Colors.OnBackground(Theme.LightColors.OnBackground)
    }

    val DarkTheme by style {
        Variables.Colors.Primary(Theme.DarkColors.Primary)
        Variables.Colors.OnPrimary(Theme.DarkColors.OnPrimary)

        Variables.Colors.Secondary(Theme.DarkColors.Secondary)
        Variables.Colors.OnSecondary(Theme.DarkColors.OnSecondary)

        Variables.Colors.Surface(Theme.DarkColors.Surface)
        Variables.Colors.OnSurface(Theme.DarkColors.OnSurface)

        Variables.Colors.Background(Theme.DarkColors.Background)
        Variables.Colors.OnBackground(Theme.DarkColors.OnBackground)
    }

}