package com.alialbaali.app.nav

import androidx.compose.runtime.*
import com.alialbaali.app.model.ProfileLinks
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.theme.style.*
import com.alialbaali.app.util.*
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.get

private const val ScrollPercentageThreshold = 1
private val MenuContainerVisibleMaxHeight = 1000.px
private val MenuContainerHiddenMaxHeight = 0.px

@Composable
fun Navbar() {
    var isMenuVisible by remember { mutableStateOf(false) }
    val sections = remember { Section.values().toList() }
    var visibleSection by remember { mutableStateOf<Section?>(null) }
    var isElevated by remember { mutableStateOf(false) }
    VisibleSectionEffect { visibleSection = it }
    window.OnScrollEffect { isElevated = window.scrollPercentage > ScrollPercentageThreshold }
    Header(
        attrs = {
            classes(NavStyleSheet.Header)
            style {
                if (isElevated) NavStyleSheet.apply { ElevatedNavbarStyle() }
                if (isMenuVisible) gap(Dimensions.Tiny) else gap(0.px)
            }
        },
    ) {
        Div(attrs = { classes(NavStyleSheet.NavContainer) }) {
            Button(attrs = {
                classes(
                    ComponentsStyleSheet.TextButton,
                    ComponentsStyleSheet.PrimaryButton,
                    NavStyleSheet.PageTitle,
                )
                onClick {
                    window.scrollToTop()
                    isMenuVisible = false
                }
            }) {
                Text(Strings.Username)
            }

            Nav(attrs = { classes(NavStyleSheet.Nav) }) {
                sections.forEach { section ->
                    Button(attrs = {
                        if (section == visibleSection) {
                            classes(ComponentsStyleSheet.TextButton, ComponentsStyleSheet.PrimaryButton)
                            style { textDecorationColor(Variables.Colors.Primary.value()) }
                        } else {
                            classes(ComponentsStyleSheet.TextButton, ComponentsStyleSheet.SecondaryButton)
                        }
                        onClick { window.scrollToSection(section) }
                    }) {
                        Text(section.name)
                    }
                }
            }

            Aside(attrs = { classes(NavStyleSheet.ProfileLinks) }) {
                ProfileLinks.All.forEach { profileLink ->
                    A(
                        href = profileLink.url,
                        attrs = {
                            title(profileLink.name)
                            target(ATarget.Blank)
                            classes(ComponentsStyleSheet.IconButton, ComponentsStyleSheet.PrimaryButton)
                        }
                    ) {
                        I(attrs = {
                            feather(profileLink.iconName)
                            classes(ComponentsStyleSheet.ProfileLinkIcon)
                        })
                    }
                }
            }

            Div(
                attrs = {
                    classes(
                        ComponentsStyleSheet.IconButton,
                        ComponentsStyleSheet.PrimaryButton,
                        NavStyleSheet.MenuIconButton,
                    )
                }
            ) {
                I(
                    attrs = {
                        classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, "fa-bars")
                        onClick { isMenuVisible = true }
                        style { fontSize(if (isMenuVisible) 0.cssRem else Dimensions.IconSize) }
                    }
                )

                I(
                    attrs = {
                        classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, "fa-xmark")
                        onClick { isMenuVisible = false }
                        style { fontSize(if (isMenuVisible) Dimensions.IconSize else 0.cssRem) }
                    }
                )
            }
        }

        Div(
            attrs = {
                classes(NavStyleSheet.MenuContainer)
                style { maxHeight(if (isMenuVisible) MenuContainerVisibleMaxHeight else MenuContainerHiddenMaxHeight) }
            },
        ) {
            Nav(attrs = { classes(NavStyleSheet.MenuNav) }) {
                sections.forEach { section ->
                    Button(attrs = {
                        if (section == visibleSection) {
                            classes(
                                ComponentsStyleSheet.TextButton,
                                ComponentsStyleSheet.PrimaryButton,
                                NavStyleSheet.MenuItem,
                            )
                            style { textDecorationColor(Variables.Colors.Primary.value()) }
                        } else {
                            classes(
                                ComponentsStyleSheet.TextButton,
                                ComponentsStyleSheet.SecondaryButton,
                                NavStyleSheet.MenuItem,
                            )
                        }
                        onClick {
                            isMenuVisible = !isMenuVisible
                            window.scrollToSection(section)
                        }
                    }) {
                        Text(section.name)
                    }
                }
            }

            Aside(attrs = { classes(NavStyleSheet.SmallProfileLinks) }) {
                ProfileLinks.All.forEach { profileLink ->
                    A(href = profileLink.url, attrs = {
                        title(profileLink.name)
                        target(ATarget.Blank)
                        classes(ComponentsStyleSheet.IconButton, ComponentsStyleSheet.PrimaryButton)
                    }) {
                        I(attrs = {
                            feather(profileLink.iconName)
                            classes(ComponentsStyleSheet.ProfileLinkIcon)
                        })
                    }
                }
            }
        }
    }
}

@Composable
private fun VisibleSectionEffect(callback: (Section?) -> Unit) {
    DisposableEffect(Unit) {
        val about = window.document.body!!.getElementsByClassName(AboutStyleSheet.Section)[0]!!
        val skills = window.document.body!!.getElementsByClassName(SkillsStyleSheet.Section)[0]!!
        val portfolio = window.document.body!!.getElementsByClassName(PortfolioStyleSheet.Section)[0]!!
        val contact = window.document.body!!.getElementsByClassName(ContactStyleSheet.Section)[0]!!
        window.document.onscroll = {
            val visibleSection = when {
                about.isPartiallyVisible -> Section.About
                skills.isPartiallyVisible -> Section.Skills
                portfolio.isPartiallyVisible -> Section.Portfolio
                contact.isPartiallyVisible -> Section.Contact
                else -> null
            }
            callback(visibleSection)
        }
        onDispose { window.document.onscroll = null }
    }
}