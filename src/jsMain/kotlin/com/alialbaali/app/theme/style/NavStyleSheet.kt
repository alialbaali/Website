package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Fonts
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
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
        fontFamily(Fonts.DancingScript)
        fontSize(Dimensions.Medium)
        padding(0.px)
        width(25.percent)
        justifyContent(JustifyContent.FlexStart)
    }

    val Nav by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignContent(AlignContent.Center)
        width(50.percent)
        justifyContent(JustifyContent.Center)
    }

    val ProfileLinks by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.FlexEnd)
        width(25.percent)
    }

}