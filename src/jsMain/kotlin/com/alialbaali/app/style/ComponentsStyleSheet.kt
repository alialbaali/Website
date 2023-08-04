package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
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
        gap(Dimensions.Tiny)
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

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny)
                gap(Dimensions.ExtraTiny)
                padding(Dimensions.ExtraTiny, Dimensions.Tiny)
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
        display(DisplayStyle.Grid)
        alignItems(AlignItems.Center)
        alignContent(AlignContent.Center)
        justifyContent(JustifyContent.Center)
        justifyItems("center")
        padding(0.px, Dimensions.Tiny)
        color(Variables.Colors.Secondary.value())
        cursor("pointer")
        textDecoration("none")
        fontSize(Dimensions.Small)

        child(self, universal) style {
            gridColumn("1")
            gridRow("1")
        }

        self + hover style { color(Variables.Colors.OnBackground.value()) }

        self + className(PrimaryButton) style {
            self + hover style { color(Variables.Colors.Primary.value()) }
        }
    }

    val Icon by style {
        fontSize(Dimensions.IconSize)
        transitions {
            all {
                duration(Dimensions.TransitionDuration)
            }
        }

        self + before style {
            display(DisplayStyle.InlineBlock)
            textDecoration("none")
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
        color(Variables.Colors.Primary.value())
        fontWeight(FontWeight.Bold)
        fontSize(Dimensions.Large)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Medium)
            }
        }
    }

    fun StyleScope.DefaultSectionStyle() {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
    }

    val Card by style {
        backgroundColor(Variables.Colors.Background.value())
        color(Variables.Colors.OnBackground.value())
        overflow("hidden")
        borderRadius(Dimensions.BorderRadius)
        border(2.px, LineStyle.Dotted, Variables.Colors.Primary.value())
    }

}