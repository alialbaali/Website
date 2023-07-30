package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.FAIcons
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import com.alialbaali.app.theme.style.ContactStyleSheet
import com.alialbaali.app.theme.style.ThemeStyleSheet
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun Contact() {
    Section(attrs = { classes(ContactStyleSheet.Section) }) {
        SectionName(Section.Contact)
        Div(attrs = { classes(ComponentsStyleSheet.Card, ContactStyleSheet.Container) }) {
            Div(attrs = { classes(ContactStyleSheet.Info) }) {
                Span(attrs = { classes(ContactStyleSheet.Title) }) {
                    Text(Strings.ContactInfoGetInTouch)
                }

                Span(attrs = { classes(ContactStyleSheet.Description) }) {
                    Text("I'm always looking for new opportunities.")
                    Br()
                    Br()
                    Text("So, feel free to contact me at anytime, whether you have a question, requesting a feature, or wanting to collaborate. And, I'll reply as fast as I can!")
                }

                Button(
                    attrs = {
                        classes(ComponentsStyleSheet.FilledButton, ComponentsStyleSheet.PrimaryButton, ContactStyleSheet.Button)
                        onClick { window.open(Links.Mail) }
                    }
                ) {
                    Text(Strings.Contact)
                    I(attrs = { classes(ComponentsStyleSheet.Icon, ThemeStyleSheet.FAIcon, FAIcons.Envelope) })
                }
            }
            Img(src = "images/Contact.svg", attrs = { classes(ContactStyleSheet.Image) })
        }
    }
}