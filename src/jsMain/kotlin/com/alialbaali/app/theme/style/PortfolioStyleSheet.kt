package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.selectors.Nth

object PortfolioStyleSheet : StyleSheet() {

    private val ProjectSpacing = Dimensions.Small
    private val ProjectDescriptionFontSize = Dimensions.ExtraSmall - 0.4.cssRem

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        gap(Dimensions.Medium)
        width(100.percent)
    }

    val ProjectContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(ProjectSpacing)
        padding(ProjectSpacing)
        height(auto)
        flex(1, 1, 50.percent - ProjectSpacing)
        self + nthChild(Nth.Functional(1, 5)) style {
            flex(1, 1, (100.percent / 3) - ProjectSpacing)
        }
        justifyContent(JustifyContent.SpaceBetween)
    }

    val HighlightedProjectContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(ProjectSpacing)
        flex(1, 1, 100.percent)
    }

    val HighlightedProjectInfoContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(ProjectSpacing)
        padding(ProjectSpacing)
        width(30.percent)
        justifyContent(JustifyContent.SpaceBetween)
    }

    val HighlightedProjectImage by style {
        height(auto)
        width(70.percent)
    }

    val ProjectInfo by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(ProjectSpacing)
    }

    val ProjectHeader by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ExtraTiny)
    }

    val ProjectTitleContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        gap(Dimensions.ExtraSmall)
    }

    val ProjectTitle by style {
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Small)
    }

    val ProjectSubtitle by style {
        color(Color.gray)
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.ExtraSmall)
    }

    val ProjectYear by style {
        color(Color.gray)
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Tiny)
    }

    val ProjectDescription by style {
        fontSize(ProjectDescriptionFontSize)
        whiteSpace("pre-line")
    }

    val ProjectFeatureContainer by style {
        fontSize(ProjectDescriptionFontSize)
        not(lastChild) style { marginBottom(Dimensions.ExtraTiny) }
        marginLeft(1.em)
    }

    val TechnologiesContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Tiny)
        flexWrap(FlexWrap.Wrap)
        margin(Dimensions.Tiny, 0.px, Dimensions.ExtraTiny)
    }

    val TechnologyItem by style {
        borderRadius(Dimensions.BorderRadius)
        padding(Dimensions.ExtraTiny, Dimensions.Tiny)
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)
        userSelect("none")
    }

    val ActionsContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Medium)
        alignSelf(AlignSelf.SelfEnd)
    }

}