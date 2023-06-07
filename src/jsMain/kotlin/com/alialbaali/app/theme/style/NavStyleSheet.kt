package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Fonts
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object NavStyleSheet : StyleSheet() {

    private val NavbarShadowHorizontalOffset = 0.px
    private val NavbarShadowVerticalOffset = 0.px
    private val NavbarShadowBlurRadius = 16.px
    private val NavbarShadowSpreadRadius = 8.px

    val Header by style {
        width(100.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        padding(Dimensions.Small, Dimensions.MainPadding)
        position(Position.Sticky)
        top(0.px)
        backgroundColor(Variables.Colors.Background.value())
        transitions {
            properties("box-shadow") {
                duration(Dimensions.TransitionDuration)
            }
        }
    }

    fun StyleScope.ElevatedNavbarStyle() {
        property(
            "box-shadow",
            """
            $NavbarShadowHorizontalOffset
            $NavbarShadowVerticalOffset
            $NavbarShadowBlurRadius
            $NavbarShadowSpreadRadius
            ${Variables.Colors.Surface.value()}
           """.trimIndent()
        )
    }

    val PageTitle by style {
        fontWeight(FontWeight.Medium)
        textDecorationLine("underline")
        textDecorationThickness(Dimensions.TextDecorationThickness)
        textDecorationColor(Color.transparent)
        property("text-underline-offset", "1rem")
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
            }
        }
        color(Variables.Colors.Primary.value())
        fontFamily(Fonts.DancingScript)
        fontSize(Dimensions.Small)
        cursor("pointer")
        userSelect("none")
        self + hover style { textDecorationColor(Variables.Colors.Primary.value()) }
    }

    val Nav by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignContent(AlignContent.Center)
        gap(Dimensions.Small)
    }

}