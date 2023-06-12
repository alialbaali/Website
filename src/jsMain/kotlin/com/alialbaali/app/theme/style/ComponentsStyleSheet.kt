package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.cssClass
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object ComponentsStyleSheet : StyleSheet() {

    val PrimaryButton by cssClass()
    val SecondaryButton by cssClass()

    val LargeButton by cssClass()
    val SmallButton by cssClass()

    private fun CSSBuilder.DefaultButtonStyle() {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ExtraTiny)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        cursor("pointer")
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.ExtraSmall)
        borderRadius(Dimensions.BorderRadius)
        padding(Dimensions.ExtraTiny, Dimensions.ExtraSmall)
        userSelect("none")
        property("text-underline-offset", Dimensions.TextUnderlineOffset)
        textDecorationColor(Color.transparent)
        textDecorationLine("underline")
        textDecorationThickness(Dimensions.TextDecorationThickness)
        border(Dimensions.OutlinedButtonBorderWidth, LineStyle.Solid, Color.transparent)
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
            }
        }

        self + className(LargeButton) style {
            padding(Dimensions.Tiny, Dimensions.ExtraSmall)
            fontSize(Dimensions.Small)
        }

        self + className(SmallButton) style {
            padding(Dimensions.ExtraTiny, Dimensions.ExtraSmall)
            fontSize(Dimensions.Tiny)
        }
    }

    val FilledButton by style {
        DefaultButtonStyle()
        backgroundColor(Variables.Colors.Surface.value())
        color(Variables.Colors.OnSurface.value())

        self + hover style {
            filter {
                brightness(Dimensions.FilledButtonHoverBrightness)
            }
        }

        self + className(PrimaryButton) style {
            backgroundColor(Variables.Colors.Primary.value())
            color(Variables.Colors.OnPrimary.value())
        }

        self + className(SecondaryButton) style {
            backgroundColor(Variables.Colors.Secondary.value())
            color(Variables.Colors.OnSecondary.value())
        }
    }

    val OutlinedButton by style {
        DefaultButtonStyle()
        backgroundColor(Variables.Colors.Background.value())
        color(Variables.Colors.OnBackground.value())
        border(Dimensions.OutlinedButtonBorderWidth, LineStyle.Solid, Variables.Colors.OnBackground.value())

        self + hover style {
            backgroundColor(Variables.Colors.OnBackground.value())
            color(Variables.Colors.Background.value())
        }

        self + className(PrimaryButton) style {
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.Primary.value())
            border(Dimensions.OutlinedButtonBorderWidth, LineStyle.Solid, Variables.Colors.Primary.value())

            self + hover style {
                backgroundColor(Variables.Colors.Primary.value())
                color(Variables.Colors.Background.value())
            }
        }

        self + className(SecondaryButton) style {
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.Secondary.value())
            border(Dimensions.OutlinedButtonBorderWidth, LineStyle.Solid, Variables.Colors.Secondary.value())

            self + hover style {
                backgroundColor(Variables.Colors.Secondary.value())
                color(Variables.Colors.Background.value())
            }
        }
    }

    val TextButton by style {
        DefaultButtonStyle()
        backgroundColor(Variables.Colors.Background.value())
        color(Variables.Colors.OnBackground.value())

        self + hover style {
            textDecorationColor(Variables.Colors.OnBackground.value())
        }

        self + className(PrimaryButton) style {
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.Primary.value())

            self + hover style {
                textDecorationColor(Variables.Colors.Primary.value())
            }
        }

        self + className(SecondaryButton) style {
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.Secondary.value())

            self + hover style {
                textDecorationColor(Variables.Colors.Secondary.value())
            }
        }
    }

    val IconButton by style {
        padding(0.px, Dimensions.ExtraTiny)
        color(Variables.Colors.Secondary.value())
        self + hover style { color(Variables.Colors.OnBackground.value()) }

        self + className(PrimaryButton) style {
            self + hover style { color(Variables.Colors.Primary.value()) }
        }
    }

    val HighlightedText by style {
        textDecorationLine("underline")
        textDecorationThickness(Dimensions.TextDecorationThickness)
        textDecorationColor(Color.transparent)
        fontWeight(FontWeight.Medium)
        property("text-underline-offset", Dimensions.TextUnderlineOffset)
        color(Variables.Colors.Primary.value())
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
            }
        }

        self + hover style { textDecorationColor(Variables.Colors.Primary.value()) }
    }

    val SectionName by style {
        margin(Dimensions.SectionNameVerticalMargin, 0.px)
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

    val Card by style {
        backgroundColor(Variables.Colors.Background.value())
        color(Variables.Colors.OnBackground.value())
        overflow("hidden")
        borderRadius(Dimensions.BorderRadius)
        property("box-shadow", "0px 0px 16px 8px ${Variables.Colors.Surface.value()}")
    }

}