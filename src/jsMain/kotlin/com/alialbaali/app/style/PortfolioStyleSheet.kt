package com.alialbaali.app.style

import com.alialbaali.app.theme.Breakpoints
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.FontWeight
import com.alialbaali.app.util.userSelect
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.selectors.Nth

object PortfolioStyleSheet : StyleSheet() {

    private val ProjectSpacing = Dimensions.Small
    private val SmallProjectSpacing = Dimensions.ExtraSmall
    private val ProjectDescriptionFontSize = Dimensions.ExtraSmall - 0.4.cssRem

    val Section by style {
        ComponentsStyleSheet.apply { DefaultSectionStyle() }
    }

    val Container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        gap(Dimensions.ItemGap)
        width(100.percent)

        media(mediaMaxWidth(Breakpoints.Large)) {
            self style {
                justifyContent(JustifyContent.Center)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.Column)
                flexWrap(FlexWrap.Nowrap)
                gap(Dimensions.SmallItemGap)
            }
        }
    }

    val ProjectContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(ProjectSpacing)
        padding(Dimensions.CardPadding)
        height(auto)
        flex(1, 1, 50.percent - ProjectSpacing)
        justifyContent(JustifyContent.SpaceBetween)

        self + nthChild(Nth.Functional(1, 6)) style {
            flex(1, 1, (100.percent / 3) - ProjectSpacing)
        }

        media(mediaMaxWidth(Breakpoints.Large)) {
            self style {
                self + nthChild(Nth.Functional(1)) style {
                    flex(1, 1, 50.percent - ProjectSpacing)
                }
            }

            self + lastChild style {
                // 4.px for border size.
                flex(0, 1, 50.percent - (ProjectSpacing / 2) - 4.px)
            }
        }

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                self + nthChild(Nth.Functional(1)) style {
                    flex(1, 1, 100.percent)
                }
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(SmallProjectSpacing)
                flex(1, 1, 100.percent)
                padding(Dimensions.SmallCardPadding)
            }
        }
    }

    val HighlightedProjectContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flex(1, 1, 100.percent)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                flexDirection(FlexDirection.ColumnReverse)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                flexDirection(FlexDirection.ColumnReverse)
            }
        }
    }

    val HighlightedProjectInfoContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(ProjectSpacing)
        padding(Dimensions.CardPadding)
        justifyContent(JustifyContent.SpaceBetween)
        width(50.percent)

        media(mediaMaxWidth(Breakpoints.Medium)) {
            self style {
                width(100.percent)
            }
        }

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(SmallProjectSpacing)
                padding(Dimensions.SmallCardPadding)
                width(100.percent)
            }
        }
    }

    val HighlightedProjectImage by style {
        property("object-fit", "contain")
        height(auto)
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

    val ProjectInfo by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(ProjectSpacing)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(SmallProjectSpacing)
            }
        }
    }

    val ProjectHeader by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Dimensions.ExtraTiny)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.ExtraTiny)
            }
        }
    }

    val ProjectTitleContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        gap(Dimensions.ExtraSmall)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.Tiny)
            }
        }
    }

    val ProjectTitle by style {
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Small)
        padding(0.px)
        border(0.px)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.ExtraSmall)
            }
        }
    }

    val ProjectSubtitle by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.ExtraSmall)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny)
            }
        }
    }

    val ProjectYear by style {
        color(Variables.Colors.Secondary.value())
        fontWeight(FontWeight.Medium)
        fontSize(Dimensions.Tiny)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny - 0.4.cssRem)
            }
        }
    }

    val ProjectDescription by style {
        fontSize(ProjectDescriptionFontSize)
        whiteSpace("pre-line")

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny)
            }
        }
    }

    val ProjectNote by style {
        fontSize(Dimensions.Tiny)
        color(Variables.Colors.Secondary.value())

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny - 0.4.cssRem)
            }
        }
    }

    val ProjectFeatureContainer by style {
        fontSize(ProjectDescriptionFontSize)
        not(lastChild) style { marginBottom(Dimensions.ExtraTiny) }
        marginLeft(1.em)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                fontSize(Dimensions.Tiny)
            }
        }
    }

    val TechnologiesContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Tiny)
        flexWrap(FlexWrap.Wrap)
        margin(Dimensions.Tiny, 0.px, Dimensions.ExtraTiny)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.ExtraTiny)
                margin(Dimensions.ExtraTiny, 0.px, Dimensions.ExtraTiny)
            }
        }
    }

    val TechnologyItem by style {
        borderRadius(Dimensions.BorderRadius)
        padding(Dimensions.ExtraTiny, Dimensions.Tiny)
        fontWeight(FontWeight.SemiBold)
        fontSize(Dimensions.Tiny)
        userSelect("none")

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                padding(Dimensions.ExtraTiny, Dimensions.Tiny - 0.4.cssRem)
                fontSize(Dimensions.Tiny - 0.4.cssRem)
            }
        }
    }

    val ActionsContainer by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        gap(Dimensions.Medium)
        alignSelf(AlignSelf.SelfEnd)

        media(mediaMaxWidth(Breakpoints.Small)) {
            self style {
                gap(Dimensions.Small)
            }
        }
    }

}