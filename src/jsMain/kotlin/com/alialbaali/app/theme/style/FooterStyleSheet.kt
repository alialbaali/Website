package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object FooterStyleSheet : StyleSheet() {

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        gap(Dimensions.Medium)
    }

    val ProfileLinks by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
    }

    val Text by style {
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny - 0.4.cssRem)
            }
        }
    }

}