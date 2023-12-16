package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object FooterStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceBetween)
        gap(Dimensions.Medium)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.Center)
            }
        }
    }

    val Text by style {
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)
        width(25.percent)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                textAlign("center")
                width(100.percent)
                fontSize(Dimensions.Tiny - 0.4.cssRem)
            }
        }
    }

    val ProfileLinks by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        flexWrap(FlexWrap.Wrap)
        width(50.percent)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent)
                gap(Dimensions.ItemGap)
                child(self, universal) style {
                    flex(1, 1, (100.percent / 4) - Dimensions.ItemGap)
                }
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(100.percent)
                gap(0.px)
                child(self, universal) style {
                    flex(1, 1, (100.percent / 4))
                }
            }
        }
    }

    val Version by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)
        textAlign("end")
        width(25.percent)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                textAlign("center")
                width(100.percent)
                fontSize(Dimensions.Tiny - 0.4.cssRem)
            }
        }
    }

}