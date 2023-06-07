package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

object AboutStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        width(100.percent)
        padding(Dimensions.Small)
    }

    val Image by style {
        width(50.percent)
        height(auto)
        borderRadius(Dimensions.BorderRadius)
        property("object-fit", "contain")
    }

    val Text by style {
        width(50.percent)
        color(Variables.Colors.OnBackground.value())
        fontWeight(FontWeight.Normal)
        fontSize(Dimensions.ExtraSmall)
    }

}