package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object FooterStyleSheet : StyleSheet() {

    val Text by style {
        width(100.percent)
        textAlign("center")
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)
        margin(Dimensions.Small)
    }

}