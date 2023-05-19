package com.alialbaali.app.theme

import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

val TransitionDuration = 250.ms
val TextDecorationThickness = 0.25.cssRem

@OptIn(ExperimentalComposeWebApi::class)
object AppStyleSheet : StyleSheet() {

    init {
        universal style {
            margin(0.px)
            padding(0.px)
            boxSizing("border-box")
        }

        "html" style {
            fontFamily(Fonts.Inter)
            fontSize(Dimensions.FontScale)
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.OnBackground.value())
        }
    }

    val LightTheme by style {
        Variables.Colors.Primary(Theme.LightColors.Primary)
        Variables.Colors.OnPrimary(Theme.LightColors.OnPrimary)
        Variables.Colors.PrimaryVariant(Theme.LightColors.PrimaryVariant)
        Variables.Colors.Secondary(Theme.LightColors.Secondary)
        Variables.Colors.OnSecondary(Theme.LightColors.OnSecondary)
        Variables.Colors.SecondaryVariant(Theme.LightColors.SecondaryVariant)
        Variables.Colors.Background(Theme.LightColors.Background)
        Variables.Colors.OnBackground(Theme.LightColors.OnBackground)
    }

    val DarkTheme by style {
        Variables.Colors.Primary(Theme.DarkColors.Primary)
        Variables.Colors.OnPrimary(Theme.DarkColors.OnPrimary)
        Variables.Colors.PrimaryVariant(Theme.DarkColors.PrimaryVariant)
        Variables.Colors.Secondary(Theme.DarkColors.Secondary)
        Variables.Colors.OnSecondary(Theme.DarkColors.OnSecondary)
        Variables.Colors.SecondaryVariant(Theme.DarkColors.SecondaryVariant)
        Variables.Colors.Background(Theme.DarkColors.Background)
        Variables.Colors.OnBackground(Theme.DarkColors.OnBackground)
    }

    val Main by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        padding(Dimensions.MainPadding)
        alignItems(AlignItems.Center)
        width(100.percent)
        gap(Dimensions.MainGap)
    }

    fun StyleScope.DefaultSectionStyle() {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
    }

    val BaseButton by style {
        cursor("pointer")
        fontWeight(FontWeight.Medium)
        borderRadius(Dimensions.BorderRadius)
        paddingLeft(Dimensions.ExtraSmall)
        paddingRight(Dimensions.ExtraSmall)
        paddingTop(Dimensions.ExtraTiny)
        paddingBottom(Dimensions.ExtraTiny)
        fontSize(Dimensions.ExtraSmall)
        border(0.px)
        userSelect("none")
    }

    val FilledButton by style {
        backgroundColor(Variables.Colors.Primary.value())
        color(Variables.Colors.OnPrimary.value())
        transitions {
            all {
                duration(TransitionDuration)
            }
        }

        self + hover style {
            backgroundColor(Variables.Colors.OnPrimary.value())
            color(Variables.Colors.Primary.value())
        }
    }

    val OutlinedButton by style {
        backgroundColor(Variables.Colors.Background.value())
        border {
            style = LineStyle.Solid
            width = 2.px
            color = Variables.Colors.Secondary.value()
        }
        color(Variables.Colors.Secondary.value())
        transitions {
            all {
                duration(TransitionDuration)
            }
        }
        self + hover style {
            backgroundColor(Variables.Colors.Secondary.value())
            color(Variables.Colors.OnSecondary.value())
        }
    }

    val TextButton by style {
        color(Variables.Colors.Primary.value())
        backgroundColor(Color.transparent)
        textDecorationLine("underline")
        textDecorationThickness(TextDecorationThickness)
        textDecorationColor(rgba(0, 109, 119, 0))
        property("text-underline-offset", "0.5rem")
        transitions {
            all {
                duration(TransitionDuration)
            }
        }

        self + hover style { TextButtonHoverStyle() }
    }

    fun StyleScope.TextButtonHoverStyle() {
        textDecorationColor(Variables.Colors.Primary.value())
    }

    val HighlightedText by style {
        fontWeight(FontWeight.Medium)
        textDecorationLine("underline")
        textDecorationThickness(TextDecorationThickness)
        textDecorationColor(rgba(226, 149, 120, 0))
        property("text-underline-offset", "1rem")
        color(Variables.Colors.SecondaryVariant.value())
        transitions {
            all {
                duration(TransitionDuration)
            }
        }
        self + hover style {
            textDecorationColor(Variables.Colors.SecondaryVariant.value())
        }
    }

    val SectionName by style {
        margin(Dimensions.Large, 0.px)
        color(Variables.Colors.OnBackground.value())
        fontWeight(FontWeight.Bold)
        fontSize(Dimensions.Large)
    }

}