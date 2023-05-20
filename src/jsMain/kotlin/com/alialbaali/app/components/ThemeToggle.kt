package com.alialbaali.app.components

import androidx.compose.runtime.*
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import com.alialbaali.app.theme.style.ThemeStyleSheet
import com.alialbaali.app.util.isSystemInDarkMode
import com.alialbaali.app.util.toggleDarkMode
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun ThemeToggle() {
    val isSystemInDarkMode = window.isSystemInDarkMode()
    var isDarkMode by remember(isSystemInDarkMode) { mutableStateOf(isSystemInDarkMode) }
    Div(attrs = { classes(ComponentsStyleSheet.ThemeToggleContainer) }) {
        Input(
            type = InputType.Checkbox,
            attrs = {
                checked(isDarkMode)
                classes(ComponentsStyleSheet.ThemeToggleInput);
                id(ComponentsStyleSheet.ThemeToggleId)
                onChange { isDarkMode = document.toggleDarkMode(isSystemInDarkMode = null) }
            }
        )
        Label(attrs = { classes(ComponentsStyleSheet.ThemeToggleLabel) }, forId = ComponentsStyleSheet.ThemeToggleId) {
            Span(attrs = { classes(ThemeStyleSheet.MaterialDesignIcons, ComponentsStyleSheet.ThemeToggleLightModeIcon) }) { Text("light_mode") }
            Span(attrs = { classes(ThemeStyleSheet.MaterialDesignIcons, ComponentsStyleSheet.ThemeToggleDarkModeIcon) }) { Text("dark_mode") }
        }
    }
}