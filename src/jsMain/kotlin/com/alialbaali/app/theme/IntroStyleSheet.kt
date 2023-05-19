package com.alialbaali.app.theme

import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object IntroStyleSheet : StyleSheet() {

    val Section by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
    }

    val Hello by style {
        marginBottom(Dimensions.ExtraTiny)
        color(Variables.Colors.PrimaryVariant.value())
        fontWeight(FontWeight.Light)
        fontSize(Dimensions.ExtraLarge)
    }

    val WhoAmI by style {
        marginTop(Dimensions.ExtraTiny)
        marginBottom(Dimensions.ExtraSmall)
        color(Variables.Colors.OnBackground.value())
        fontWeight(FontWeight.Normal)
        fontSize(Dimensions.ExtraHuge)
    }

    val WhatDoIDo by style {
        marginTop(Dimensions.ExtraSmall)
        marginBottom(Dimensions.Small)
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Medium)
        width(75.percent)
    }

    val ButtonsContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Small)
    }

}