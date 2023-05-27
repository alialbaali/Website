package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object ComponentsStyleSheet : StyleSheet() {

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
                duration(Dimensions.TransitionDuration)
            }
        }

        self + hover style {
            filter {
                brightness(Dimensions.FilledButtonHoverBrightness)
            }
        }
    }

    val OutlinedButton by style {
        backgroundColor(Variables.Colors.Background.value())
        border {
            style = LineStyle.Solid
            width = Dimensions.OutlinedButtonBorderWidth
            color = Variables.Colors.Secondary.value()
        }
        color(Variables.Colors.Secondary.value())
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
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
        textDecorationThickness(Dimensions.TextDecorationThickness)
        textDecorationColor(rgba(0, 109, 119, 0))
        property("text-underline-offset", "0.5rem")
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
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
        textDecorationThickness(Dimensions.TextDecorationThickness)
        textDecorationColor(rgba(226, 149, 120, 0))
        property("text-underline-offset", "1rem")
        color(Variables.Colors.SecondaryVariant.value())
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
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

    fun StyleScope.DefaultSectionStyle() {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
    }

    const val ThemeToggleId = "Toggle"

    val ThemeToggleContainer by style {}

    val ThemeToggleLabel by style {
        display(DisplayStyle.Grid)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        width(100.percent)
        backgroundColor(Variables.Colors.Background.value())
        cursor("pointer")
        borderRadius(3.vmin)
        border(Dimensions.OutlinedButtonBorderWidth, LineStyle.Solid, Variables.Colors.Primary.value())
    }

    val ThemeToggleLightModeIcon by style {
        gridColumn(1, 1)
        gridRow(1, 1)
        color(Variables.Colors.Primary.value())
        padding(Dimensions.ExtraTiny)
        opacity(1)
        userSelect("none")
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
            }
        }
    }

    val ThemeToggleDarkModeIcon by style {
        gridColumn(1, 1)
        gridRow(1, 1)
        color(Variables.Colors.Primary.value())
        padding(Dimensions.ExtraTiny)
        opacity(0)
        userSelect("none")
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
            }
        }
    }

    val ThemeToggleInput by style {
        display(DisplayStyle.None)
        adjacent(self + checked, desc(className(ThemeToggleLabel), className(ThemeToggleLightModeIcon))) style {
            opacity(0)
        }

        adjacent(self + checked, desc(className(ThemeToggleLabel), className(ThemeToggleDarkModeIcon))) style {
            opacity(1)
        }
    }

}