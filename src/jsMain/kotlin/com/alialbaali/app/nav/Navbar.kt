package com.alialbaali.app.nav

import androidx.compose.runtime.*
import com.alialbaali.app.model.FAIcons
import com.alialbaali.app.model.FAIcons.faIcon
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.style.*
import com.alialbaali.app.theme.Dimensions
import com.alialbaali.app.theme.Theme
import com.alialbaali.app.theme.Variables
import com.alialbaali.app.util.*
import kotlinx.browser.localStorage
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.get

private const val ScrollPercentageThreshold = 1
private val MenuContainerVisibleMaxHeight = 1000.px
private val MenuContainerHiddenMaxHeight = 0.px

@Composable
fun Navbar() {
    val sections = Section.entries
    var isMenuVisible by remember { mutableStateOf(false) }
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
            Button(
                attrs = {
                    classes(
                        ComponentsStyleSheet.TextButton,
                        ComponentsStyleSheet.PrimaryButton,
                        NavStyleSheet.Title,
                    )
                    onClick {
                        window.scrollToTop()
                        isMenuVisible = false
                    }
                }
            ) { Text(Strings.Username) }

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

            Aside(attrs = { classes(NavStyleSheet.Aside) }) {
                Div(attrs = { classes(NavStyleSheet.ProfileLinks) }) {
                    Links.Profile.entries.forEach { profileLink ->
                        A(
                            href = profileLink.url,
                            attrs = {
                                title(profileLink.name)
                                target(ATarget.Blank)
                                classes(ComponentsStyleSheet.IconButton, ComponentsStyleSheet.PrimaryButton)
                            },
                        ) {
                            I(
                                attrs = {
                                    classes(
                                        ComponentsStyleSheet.Icon,
                                        ThemeStyleSheet.FABrand,
                                        profileLink.faIcon
                                    )
                                }
                            )
                        }
                    }
                }

                ThemeToggle()
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
                        classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Menu)
                        onClick { isMenuVisible = true }
                        style { fontSize(if (isMenuVisible) 0.em else Dimensions.IconSize) }
                    }
                )

                I(
                    attrs = {
                        classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Close)
                        onClick { isMenuVisible = false }
                        style { fontSize(if (isMenuVisible) Dimensions.IconSize else 0.em) }
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
                Links.Profile.entries.forEach { profileLink ->
                    A(
                        href = profileLink.url,
                        attrs = {
                            title(profileLink.name)
                            target(ATarget.Blank)
                            classes(ComponentsStyleSheet.IconButton, ComponentsStyleSheet.PrimaryButton)
                        },
                    ) { I(attrs = { classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FABrand, profileLink.faIcon) }) }
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


@Composable
private fun ThemeToggle() {
    val storageStatus = localStorage.getItem(StorageIds.Theme)?.toThemeStatus()
    val windowStatus = window.themeStatus
    var state by remember(windowStatus) { mutableStateOf(storageStatus ?: windowStatus) }

    Div(attrs = { classes(NavStyleSheet.ThemeToggleContainer) }) {
        Input(
            type = InputType.Checkbox,
            attrs = {
                checked(state.isDark)
                classes(NavStyleSheet.ThemeToggleInput);
                id(NavStyleSheet.ThemeToggleId)
                onChange {
                    val newState = if (state.isLight) Theme.Status.Dark else Theme.Status.Light
                    state = newState // Update UI
                    localStorage.setItem(StorageIds.Theme, newState.name) // Update initial status
                    window.toggleThemeStatus() // Toggle UI theme
                }
            }
        )
        Label(
            attrs = { classes(ComponentsStyleSheet.IconButton, ComponentsStyleSheet.PrimaryButton) },
            forId = NavStyleSheet.ThemeToggleId,
        ) {
            I(
                attrs = {
                    classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Sun)
                    style { fontSize(if (state.isDark) Dimensions.IconSize else 0.em) }
                }
            )

            I(
                attrs = {
                    classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Moon)
                    style { fontSize(if (state.isLight) Dimensions.IconSize else 0.em) }
                }
            )
        }
    }
}