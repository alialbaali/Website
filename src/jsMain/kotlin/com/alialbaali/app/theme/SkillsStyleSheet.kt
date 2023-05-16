package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.*

object SkillsStyleSheet : StyleSheet() {

    val Section by style {
        AppStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        padding(Dimensions.Small)
        backgroundColor(Colors.Primary)
        borderRadius(Dimensions.BorderRadius)
    }

    val Item by style {
        width(20.percent)
        textAlign("center")
        padding(Dimensions.Small)
    }

    val Image by style {
        width(50.percent)
    }

}