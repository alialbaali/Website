package com.alialbaali.app.theme

import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

object AboutStyleSheet : StyleSheet() {

    val Section by style {
        AppStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ExtraSmall)
        width(100.percent)
    }

    val Image by style {
        maxWidth(30.percent)
        height(auto)
        backgroundColor(Variables.Colors.Primary.value())
        borderRadius(Dimensions.BorderRadius)
        property("object-fit", "cover")
    }

    val Text by style {
        width(70.percent)
        color(Variables.Colors.Primary.value())
        fontWeight(FontWeight.Normal)
        fontSize(Dimensions.ExtraSmall)
    }

}