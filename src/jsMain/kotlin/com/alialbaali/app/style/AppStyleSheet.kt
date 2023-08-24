package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Fonts
import com.alialbaali.app.theme.Variables
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object AppStyleSheet : StyleSheet() {

    init {
        universal style {
            margin(0.px)
            padding(0.px)
            boxSizing("border-box")
            transitions {
                properties("color", "background-color") {
                    duration(Dimensions.TransitionDuration)
                }
            }
        }

        "html" style {
            fontFamily(Fonts.Inter)
            fontSize(Dimensions.FontScale)
            backgroundColor(Variables.Colors.Background.value())
            color(Variables.Colors.OnBackground.value())
            property("text-decoration-skip-ink", "none")
        }
    }

    val Main by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        padding(Dimensions.DefaultMainPadding)
        alignItems(AlignItems.Center)
        width(100.percent)
        gap(Dimensions.DefaultMainGap)

        media(mediaMaxWidth(Breakpoints.Large)) {
            self style {
                padding(Dimensions.LargeMainPadding)
                gap(Dimensions.LargeMainGap)
            }
        }

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                padding(Dimensions.MediumMainPadding)
                gap(Dimensions.MediumMainGap)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                padding(Dimensions.SmallMainPadding)
                gap(Dimensions.SmallMainGap)
            }
        }
    }

}