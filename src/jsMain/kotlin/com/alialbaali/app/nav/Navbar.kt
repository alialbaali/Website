package com.alialbaali.app.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.NavStyleSheet
import com.alialbaali.app.util.scrollToSection
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text

@Composable
fun Navbar(onHeaderHeightChanged: (Int) -> Unit) {
    val sections = remember { Section.values().toList() }
    Header(
        attrs = {
            classes(NavStyleSheet.Header)
            ref { header ->
                onHeaderHeightChanged(header.clientHeight)
                onDispose { onHeaderHeightChanged(0) }
            }
        }
    ) {
        A(attrs = { classes(NavStyleSheet.PageTitle) }) { Text(Strings.Username) }
        Nav(attrs = { classes(NavStyleSheet.Nav) }) {
            sections.forEach { section ->
                A(
                    attrs = {
                        classes(AppStyleSheet.BaseButton, AppStyleSheet.TextButton)
                        onClick { window.scrollToSection(section) }
                    }
                ) {
                    Text(section.name)
                }
            }
        }
    }
}