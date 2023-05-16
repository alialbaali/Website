package com.alialbaali.app.theme

import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object NavStyleSheet : StyleSheet() {

    val Header by style {
        width(100.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(Dimensions.MainPadding)
        position(Position.Sticky)
        top(0.px)
        backgroundColor(Colors.Background)
    }

    val PageTitle by style {
        fontWeight(FontWeight.Medium)
        textDecorationLine("underline")
        textDecorationThickness(TextDecorationThickness)
        textDecorationColor(rgba(255, 255, 255, 0))
        property("text-underline-offset", "1rem")
        transitions {
            all {
                duration(TransitionDuration)
            }
        }
        color(Colors.OnBackground)
        fontFamily(Fonts.DancingScript)
        fontSize(Dimensions.Small)
        cursor("pointer")
        userSelect("none")
        self + hover style {
            textDecorationColor(Colors.OnBackground)
        }
    }

    val Nav by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignContent(AlignContent.Center)
        gap(Dimensions.Small)
    }

}