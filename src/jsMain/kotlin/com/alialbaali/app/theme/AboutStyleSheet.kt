package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.*

object AboutStyleSheet : StyleSheet() {

    val Section by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ExtraSmall)
        alignItems(AlignItems.Start)
        minHeight(100.vh)
    }

    val Image by style {
        maxWidth(30.percent)
        backgroundColor(Colors.Primary)
        borderRadius(Dimensions.BorderRadius)
    }

    val Text by style {
        width(70.percent)
        color(Colors.Primary)
        fontWeight("normal")
        fontSize(Dimensions.ExtraSmall)
    }

}