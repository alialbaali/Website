package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba

object Theme {

    object LightColors {
        val Primary = rgb(0, 109, 119)
        val OnPrimary = rgb(255, 255, 255)
        val PrimaryVariant = rgb(131, 197, 190)

        val Secondary = rgb(226, 149, 120)
        val OnSecondary = rgb(255, 255, 255)
        val SecondaryVariant = rgb(255, 221, 210)

        val Background = Color.white
        val OnBackground = Color.black

        val NavbarShadow = rgba(0, 0, 0, 0.1)
    }

    object DarkColors {
        val Primary = rgb(0, 109, 119)
        val OnPrimary = rgb(255, 255, 255)
        val PrimaryVariant = rgb(131, 197, 190)

        val Secondary = rgb(226, 149, 120)
        val OnSecondary = rgb(255, 255, 255)
        val SecondaryVariant = rgb(255, 221, 210)

        val Background = Color.black
        val OnBackground = Color.white

        val NavbarShadow = rgba(255, 255, 255, 0.1)
    }

}