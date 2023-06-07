package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object IntroStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
        gap(Dimensions.ItemGap * 2)
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        justifyContent(JustifyContent.Center)
    }

    val TextContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(50.percent)
        gap(Dimensions.ItemGap)
    }

    val IntroTextContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
    }

    val Image by style {
        width(50.percent)
        property("object-fit", "contain")
    }

    val Hello by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Light)
        fontSize(Dimensions.Medium)
        width(75.percent)
    }

    val WhoAmI by style {
        color(Variables.Colors.Primary.value())
        fontWeight(FontWeight.Normal)
        fontSize(Dimensions.Large)
    }

    val WhatDoIDo by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Small)
    }

    val ButtonsContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Small)
    }

}