package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object IntroStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        alignItems(AlignItems.FlexEnd)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                flexDirection(FlexDirection.ColumnReverse)
                alignItems(AlignItems.Center)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.ColumnReverse)
                gap(Dimensions.SmallItemGap)
                alignItems(AlignItems.Center)
            }
        }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ItemGap * 2)
        width(50.percent)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(100.percent)
                gap(Dimensions.SmallItemGap * 2)
            }
        }
    }

    val Image by style {
        property("object-fit", "contain")
        width(50.percent)

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

    val TextContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ItemGap)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.SmallItemGap)
            }
        }
    }

    val IntroTextContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
    }

    val Hello by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Light)
        fontSize(Dimensions.Medium)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Small)
            }
        }
    }

    val WhoAmI by style {
        color(Variables.Colors.Primary.value())
        fontWeight(FontWeight.Normal)
        fontSize(Dimensions.Large)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Medium)
            }
        }
    }

    val WhatDoIDo by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Small)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.ExtraSmall)
            }
        }
    }

    val ButtonsContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Small)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.ExtraSmall)
            }
        }
    }

}