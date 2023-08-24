package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import org.jetbrains.compose.web.css.*

object SkillsStyleSheet : StyleSheet() {

    private val CategoryItemSpacing = Dimensions.ItemGap
    private val SmallCategoryItemSpacing = Dimensions.SmallItemGap
    private val CategoryContentSpacing = Dimensions.CardPadding
    private val SmallCategoryContentSpacing = Dimensions.SmallCardPadding
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

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.Column)
                flexWrap(FlexWrap.Nowrap)
                gap(SmallCategoryItemSpacing)
            }
        }
    }

    val CategoryItem by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width((100.percent / 3) - CategoryItemSpacing)
        flexGrow(1)

        media(mediaMaxWidth(Breakpoints.Large)) {
            self style {
                width((100.percent / 2) - CategoryItemSpacing)
            }
        }

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width((100.percent / 2) - CategoryItemSpacing)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(100.percent)
            }
        }
    }

    val CategoryTitle by style {
        fontSize(Dimensions.Small)
        fontWeight(FontWeight.SemiBold)
        padding(CategoryContentSpacing)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.ExtraSmall)
                padding(SmallCategoryContentSpacing)
            }
        }
    }

    val CategoryDivider by style {
        margin(0.px, CategoryContentSpacing)
        border(2.px, LineStyle.Solid, Variables.Colors.Surface.value())
        borderRadius(Dimensions.BorderRadius)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                margin(0.px, SmallCategoryContentSpacing)
            }
        }
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

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent / 2)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.Tiny)
                padding(SmallCategoryContentSpacing)
                width(100.percent / 4)
            }
        }
    }

    val TechnologyTitle by style {
        fontSize(Dimensions.ExtraSmall)
        fontWeight(FontWeight.Medium)
        textAlign("center")

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny)
            }
        }
    }

    val TechnologyImage by style {
        width(TechnologyImageSize)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                width(TechnologyImageSize / 2)
            }
        }
    }

}