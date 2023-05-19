package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Fonts
import com.alialbaali.app.theme.Variables
import org.jetbrains.compose.web.css.*

object AppStyleSheet : StyleSheet() {

    init {
        universal style {
            margin(0.px)
            padding(0.px)
            boxSizing("border-box")
        }

        "html" style {
            fontFamily(Fonts.Inter)
            fontSize(Dimensions.FontScale)
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.OnBackground.value())
        }
    }

    val Main by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        padding(Dimensions.MainPadding)
        alignItems(AlignItems.Center)
        width(100.percent)
        gap(Dimensions.MainGap)
    }

}