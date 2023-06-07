package com.alialbaali.app.theme.style

import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object SkillsStyleSheet : StyleSheet() {

    private val CategoryItemSpacing = Dimensions.ItemGap
    private val CategoryContentSpacing = Dimensions.Small
    private val TechnologyImageSize = 64.px

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        gap(CategoryItemSpacing)
        width(100.percent)
    }

    val CategoryItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width((100.percent / 3) - CategoryItemSpacing)
        flexGrow(1)
    }

    val CategoryTitle by style {
        fontSize(Dimensions.Small)
        fontWeight(FontWeight.SemiBold)
        padding(CategoryContentSpacing)
    }

    val CategoryDivider by style {
        margin(0.px, CategoryContentSpacing)
        border(2.px, LineStyle.Solid, Variables.Colors.Surface.value())
        borderRadius(Dimensions.BorderRadius)
    }

    val TechnologiesContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        alignItems(AlignItems.Stretch)
    }

    val TechnologyItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        gap(Dimensions.ExtraSmall)
        padding(CategoryContentSpacing)
        width(100.percent / 3)
    }

    val TechnologyTitle by style {
        fontSize(Dimensions.ExtraSmall)
        fontWeight(FontWeight.Medium)
        textAlign("center")
    }

    val TechnologyImage by style {
        width(TechnologyImageSize)
    }

}