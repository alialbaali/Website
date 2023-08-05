package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import org.jetbrains.compose.web.css.*

object ContactStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        padding(Dimensions.CardPadding)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                flexDirection(FlexDirection.ColumnReverse)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.ColumnReverse)
                gap(Dimensions.SmallItemGap)
                padding(Dimensions.SmallCardPadding)
            }
        }
    }

    val Info by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ItemGap)
        width(50.percent)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(100.percent)
                gap(Dimensions.SmallItemGap)
            }
        }
    }

    val Image by style {
        width(50.percent)
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

    val Title by style {
        fontSize(Dimensions.Small)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.ExtraSmall)
            }
        }
    }

    val Description by style {
        fontSize(Dimensions.ExtraSmall)
        color(Variables.Colors.Secondary.value())

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny)
            }
        }
    }

    val Button by style {
        property("width", "min-content")
        property("margin-top", "auto")
    }

}