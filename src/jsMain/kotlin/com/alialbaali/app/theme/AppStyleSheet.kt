package com.alialbaali.app.theme

import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

private val TransitionDuration = 250.ms
private val TextDecorationThickness = 0.25.cssRem

@OptIn(ExperimentalComposeWebApi::class)
object AppStyleSheet : StyleSheet() {

    init {
        universal style {
            margin(0.px)
            padding(0.px)
            boxSizing("border-box")
        }

        "html" style {
            fontFamily("Inter")
            fontSize(62.5.percent)
            backgroundColor(Colors.Background)
            color(Colors.OnBackground)
        }
    }

    val BaseButton by style {
        cursor("pointer")
        fontWeight("medium")
        borderRadius(Dimensions.BorderRadius)
        paddingLeft(Dimensions.ExtraSmall)
        paddingRight(Dimensions.ExtraSmall)
        paddingTop(Dimensions.ExtraTiny)
        paddingBottom(Dimensions.ExtraTiny)
        fontSize(Dimensions.ExtraSmall)
        border(0.px)
    }

    val FilledButton by style {
        backgroundColor(Colors.Primary)
        color(Colors.OnPrimary)
        transitions {
            all {
                duration(TransitionDuration)
            }
        }

        self + hover style {
            backgroundColor(Colors.OnPrimary)
            color(Colors.Primary)
        }
    }

    val OutlinedButton by style {
        backgroundColor(Colors.Background)
        border {
            style = LineStyle.Solid
            width = 2.px
            color = Colors.Secondary
        }
        color(Colors.Secondary)
        transitions {
            all {
                duration(TransitionDuration)
            }
        }
        self + hover style {
            backgroundColor(Colors.Secondary)
            color(Colors.OnSecondary)
        }
    }

    val TextButton by style {
        color(Colors.Primary)
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

        self + hover style {
            textDecorationColor(Colors.Primary)
        }
    }


    val HighlightedText by style {
        fontWeight("medium")
        textDecorationLine("underline")
        textDecorationThickness(TextDecorationThickness)
        textDecorationColor(rgba(226, 149, 120, 0))
        property("text-underline-offset", "1rem")
        color(Colors.SecondaryVariant)
        transitions {
            all {
                duration(TransitionDuration)
            }
        }
        self + hover style {
            textDecorationColor(Colors.SecondaryVariant)
        }
    }

    val PageTitle by style {
        fontWeight("medium")
        textDecorationLine("underline")
        textDecorationThickness(TextDecorationThickness)
        textDecorationColor(rgba(255, 255, 255, 0))
        property("text-underline-offset", "1rem")
        color(Colors.OnBackground)
        fontFamily("Dancing Script")
        fontSize(Dimensions.Small)
        cursor("pointer")
        transitions {
            all {
                duration(TransitionDuration)
            }
        }
        self + hover style {
            textDecorationColor(Colors.OnBackground)
        }
    }

    val Main by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        padding(Dimensions.Medium)
        alignItems(AlignItems.Center)
        width(100.percent)
        gap(Dimensions.Medium)
    }

}