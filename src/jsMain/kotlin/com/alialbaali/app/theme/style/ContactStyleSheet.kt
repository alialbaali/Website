package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import org.jetbrains.compose.web.css.*

object ContactStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        padding(Dimensions.CardPadding)
    }

    val Info by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ItemGap)
        width(50.percent)
    }

    val Image by style {
        width(50.percent)
        property("object-fit", "contain")
    }

    val Title by style {
        fontSize(Dimensions.Medium)
    }

    val Description by style {
        fontSize(Dimensions.ExtraSmall)
        color(Variables.Colors.Secondary.value())
    }

    val Button by style {
        property("width", "min-content")
    }

}