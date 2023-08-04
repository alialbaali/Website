package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
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

    const val ThemeToggleId = "ThemeToggle"

    val Header by style {
        width(100.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        padding(Dimensions.Small, Dimensions.MainPadding)
        position(Position.Sticky)
        top(0.px)
        backgroundColor(Variables.Colors.Background.value())
        transitions {
            properties("box-shadow", "gap") {
                duration(Dimensions.TransitionDuration)
            }
        }

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                padding(Dimensions.ExtraSmall, Dimensions.MediumMainPadding)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                padding(Dimensions.ExtraSmall, Dimensions.SmallMainPadding)
            }
        }
    }

    fun StyleScope.ElevatedNavbarStyle() {
        property(
            "box-shadow", """
            $NavbarShadowHorizontalOffset
            $NavbarShadowVerticalOffset
            $NavbarShadowBlurRadius
            $NavbarShadowSpreadRadius
            ${Variables.Colors.Surface.value()}
           """.trimIndent()
        )
    }

    val NavContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceBetween)
    }

    val Title by style {
        fontWeight(FontWeight.Medium)
        fontFamily(Fonts.DancingScript)
        fontSize(Dimensions.Medium)
        padding(0.px)
        width(25.percent)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.FlexStart)
    }

    val Nav by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        width(50.percent)
        justifyContent(JustifyContent.Center)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                display(DisplayStyle.None)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                display(DisplayStyle.None)
            }
        }
    }

    val Aside by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.FlexEnd)
        width(25.percent)
    }

    val ThemeToggleContainer by style {}

    val ThemeToggleInput by style {
        display(DisplayStyle.None)
    }

    val MenuIconButton by style {
        media(mediaMinWidth(Breakpoints.Medium)) {
            self style {
                display(DisplayStyle.None)
            }
        }
    }

    val MenuContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        backgroundColor(Variables.Colors.Background.value())
        width(100.percent)
        overflow("hidden")

        transitions {
            properties("max-height") {
                duration(Dimensions.TransitionDuration)
            }
        }
    }

    val MenuNav by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
    }

    val MenuItem by style {
        paddingLeft(0.px)
        paddingRight(0.px)
        width(100.percent)
        justifyContent(JustifyContent.FlexStart)
        alignItems(AlignItems.FlexStart)
    }

}