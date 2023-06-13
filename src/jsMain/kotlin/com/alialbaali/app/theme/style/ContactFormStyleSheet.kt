package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Fonts
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
object ContactFormStyleSheet : StyleSheet() {

    private val InputSpacing = Dimensions.ItemGap
    private val InputBorderWidth = 2.px
    private val InputBorderStyle = LineStyle.Solid
    private val MessageMinHeight = Dimensions.Medium * 4
    const val EmailId = "email"
    const val SubjectId = "subject"
    const val MessageId = "message"
//    val EmailRegex = Regex("(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.ItemGap)
        width(100.percent)
    }

    val Info by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(50.percent)
    }

    val InfoText by style {
        fontSize(Dimensions.ExtraLarge)
    }

    val Form by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(InputSpacing)
        padding(Dimensions.CardPadding)
        width(50.percent)
    }

    val InputContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ExtraTiny)
    }

    val InputLabel by style {
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Tiny)
    }

    val DefaultInput by style {
        padding(Dimensions.Tiny)
        fontSize(Dimensions.Tiny)

        borderRadius(Dimensions.BorderRadius)
        backgroundColor(Variables.Colors.Secondary.value())

        outline("none")
        border(InputBorderWidth, InputBorderStyle, Color.transparent)

        transitions {
            properties("border") {
                duration(Dimensions.TransitionDuration)
            }
        }

        self + hover style {
            border(InputBorderWidth, InputBorderStyle, Variables.Colors.Primary.value())
        }

        self + focus style {
            border(InputBorderWidth, InputBorderStyle, Variables.Colors.Primary.value())
        }
    }

    val EmailInput by style {}

    val SubjectInput by style {}

    val MessageInput by style {
        property("resize", "vertical")
        minHeight(MessageMinHeight)
        fontFamily(Fonts.Inter)
    }

}