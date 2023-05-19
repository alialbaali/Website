package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import org.jetbrains.compose.web.css.*

object SkillsStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        padding(Dimensions.Small)
        backgroundColor(Variables.Colors.Primary.value())
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