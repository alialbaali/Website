package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.variable

object Variables {

    object Colors {
        val Primary by variable<CSSColorValue>()
        val OnPrimary by variable<CSSColorValue>()
        val PrimaryVariant by variable<CSSColorValue>()

        val Secondary by variable<CSSColorValue>()
        val OnSecondary by variable<CSSColorValue>()
        val SecondaryVariant by variable<CSSColorValue>()

        val Background by variable<CSSColorValue>()
        val OnBackground by variable<CSSColorValue>()
    }

}