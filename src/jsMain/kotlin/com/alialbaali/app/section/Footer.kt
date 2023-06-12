package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.model.ProfileLinks
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import com.alialbaali.app.theme.style.FooterStyleSheet
import com.alialbaali.app.util.feather
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*
import kotlin.js.Date

@Composable
fun Footer() {
    val currentYear = remember { Date().getFullYear() }
    Footer(attrs = { classes(FooterStyleSheet.Section) }) {
        Span(attrs = { classes(FooterStyleSheet.Text) }) { Text("$currentYear © Ali Albaali — One step at a time") }
        Div(attrs = { classes(FooterStyleSheet.ProfileLinks) }) {
            ProfileLinks.All.forEach { profileLink ->
                A(profileLink.url,
                    attrs = {
                        title(profileLink.name)
                        target(ATarget.Blank)
                        classes(ComponentsStyleSheet.IconButton, ComponentsStyleSheet.PrimaryButton)
                    }
                ) {
                    I(attrs = { feather(profileLink.iconName) })
                }
            }
        }
    }
}