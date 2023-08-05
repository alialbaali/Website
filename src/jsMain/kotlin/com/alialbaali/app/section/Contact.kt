package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.FAIcons
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.style.ContactStyleSheet
import com.alialbaali.app.style.ThemeStyleSheet
import com.alialbaali.app.theme.Theme
import com.alialbaali.app.util.themeStatusAsFlow
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun Contact() {
    val themeStatus by window.themeStatusAsFlow().collectAsState(Theme.Status.Light)
    val imageUrl = if (themeStatus.isDark) "images/Contact-Light.svg" else "images/Contact-Dark.svg"
    Section(attrs = { classes(ContactStyleSheet.Section) }) {
        SectionName(Section.Contact)
        Div(attrs = { classes(ComponentsStyleSheet.Card, ContactStyleSheet.Container) }) {
            Div(attrs = { classes(ContactStyleSheet.Info) }) {
                Span(attrs = { classes(ContactStyleSheet.Title) }) {
                    Text(Strings.ContactInfoTitle)
                }

                Span(attrs = { classes(ContactStyleSheet.Description) }) {
                    Text(Strings.ContactParagraph[0])
                    Br()
                    Br()
                    Text(Strings.ContactParagraph[1])
                }

                Button(
                    attrs = {
                        classes(
                            ComponentsStyleSheet.FilledButton,
                            ComponentsStyleSheet.PrimaryButton,
                            ContactStyleSheet.Button,
                        )
                        onClick { window.open(Links.Mail) }
                    }
                ) {
                    Text(Strings.Contact)
                    I(attrs = { classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Envelope) })
                }
            }
            Img(src = imageUrl, attrs = { classes(ContactStyleSheet.Image) })
        }
    }
}