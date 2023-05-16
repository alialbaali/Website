package com.alialbaali.app.theme

import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto

object PortfolioStyleSheet : StyleSheet() {

    val Section by style {
        AppStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        gap(Dimensions.Medium)
        width(100.percent)
    }

    val HighlightedProject by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Small)
        backgroundColor(Colors.Primary)
        borderRadius(Dimensions.BorderRadius)
        overflow("clip")
        flex(1, 1, 100.percent)
    }

    val HighlightedProjectInfo by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.Small)
        width(30.percent)
        padding(Dimensions.Tiny)
    }

    val HighlightedProjectImage by style {
        height(auto)
        width(70.percent)
    }

    val HighlightedProjectHeader by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.Tiny)
    }

    val HighlightedProjectName by style {
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Medium)
    }

    val HighlightedProjectDescription by style {
        fontWeight(FontWeight.Normal)
        fontSize(2.0.cssRem)
    }

    val Project by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.Small)
        backgroundColor(Colors.Primary)
        borderRadius(Dimensions.BorderRadius)
        padding(Dimensions.Tiny)
        height(auto)
        flex(1, 1, 25.percent)
    }

    val TechnologyName by style {
        borderRadius(Dimensions.BorderRadius)
        padding(Dimensions.ExtraTiny, Dimensions.Tiny)
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)
        userSelect("none")
    }

    val TechnologiesContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Tiny)
        flexWrap(FlexWrap.Wrap)
    }

}