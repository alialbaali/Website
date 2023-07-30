package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.rgb

object Theme {

    enum class Status {
        Light, Dark;

        val isLight get() = this == Light
        val isDark get() = this == Dark
    }

    object LightColors {
        val Primary = Color("#3F51B5")
        val OnPrimary = rgb(255, 255, 255)

        val Secondary = Color("#757575")
        val OnSecondary = Color.black

        val Surface = Color("#F5F5F5")
        val OnSurface = Color.black

        val Background = Color.white
        val OnBackground = Color.black
    }

    object DarkColors {
        val Primary = Color("#9FA8DA")
        val OnPrimary = Color.black

        val Secondary = Color("#757575")
        val OnSecondary = Color.white

        val Surface = Color("#424242")
        val OnSurface = Color.white

        val Background = Color.black
        val OnBackground = Color.white
    }

}