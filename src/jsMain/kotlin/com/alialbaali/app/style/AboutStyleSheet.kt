package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

object AboutStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        width(100.percent)
        padding(Dimensions.CardPadding)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                flexDirection(FlexDirection.Column)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.Column)
                gap(Dimensions.SmallItemGap)
                padding(Dimensions.SmallCardPadding)
            }
        }
    }

    val Image by style {
        width(50.percent)
        height(auto)
        borderRadius(Dimensions.BorderRadius)
        property("object-fit", "contain")

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(100.percent)
            }
        }
    }

    val Text by style {
        width(50.percent)
        color(Variables.Colors.OnBackground.value())
        fontWeight(FontWeight.Normal)
        fontSize(Dimensions.ExtraSmall)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(100.percent)
                fontSize(Dimensions.Tiny)
            }
        }
    }

}