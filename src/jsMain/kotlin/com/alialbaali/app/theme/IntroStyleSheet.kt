package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.*

object IntroStyleSheet : StyleSheet() {

    val Section by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        minHeight(100.vh)
    }

    val Hello by style {
        marginBottom(Dimensions.ExtraTiny)
        color(Colors.PrimaryVariant)
        fontWeight("light")
        fontSize(Dimensions.ExtraLarge)
    }

    val WhoAmI by style {
        marginTop(Dimensions.ExtraTiny)
        marginBottom(Dimensions.ExtraSmall)
        color(Colors.OnBackground)
        fontWeight("normal")
        fontSize(Dimensions.ExtraHuge)
    }

    val WhatDoIDo by style {
        marginTop(Dimensions.ExtraSmall)
        marginBottom(Dimensions.Small)
        color(Colors.Secondary)
        fontWeight("medium")
        fontSize(Dimensions.Medium)
        width(75.percent)
    }

    val ButtonsContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Small)
    }

}