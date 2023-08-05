package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.style.ContactFormStyleSheet
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.required
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm() {
    Section(attrs = { classes(ContactFormStyleSheet.Section) }) {
        SectionName(Section.Contact)
        Div(attrs = { classes(ContactFormStyleSheet.Container) }) {
            Div(attrs = { classes(ContactFormStyleSheet.Info) }) {
                Span(attrs = { classes(ContactFormStyleSheet.InfoText) }) { Text(Strings.ContactInfoTitle) }
                Span(attrs = { classes(ContactFormStyleSheet.InfoText) }) {
                    Text(Strings.ContactParagraph[0])
                    Br()
                    Br()
                    Text(Strings.ContactParagraph[1])
                }
            }

            Form(attrs = { classes(ComponentsStyleSheet.Card, ContactFormStyleSheet.Form) }, action = Links.Mail) {
                Div(attrs = { classes(ContactFormStyleSheet.InputContainer) }) {
                    Label(
                        forId = ContactFormStyleSheet.EmailId,
                        attrs = { classes(ContactFormStyleSheet.InputLabel) }) { Text(Strings.Email) }
                    Input(
                        InputType.Email,
                        attrs = {
                            id(ContactFormStyleSheet.EmailId)
                            name(Strings.Email)
                            classes(ContactFormStyleSheet.DefaultInput, ContactFormStyleSheet.EmailInput)
                            placeholder(Strings.EmailPlaceholder)
                            required()
                        }
                    )
                }

                Div(attrs = { classes(ContactFormStyleSheet.InputContainer) }) {
                    Label(
                        forId = ContactFormStyleSheet.SubjectId,
                        attrs = { classes(ContactFormStyleSheet.InputLabel) }) { Text(Strings.Subject) }
                    Input(
                        InputType.Text,
                        attrs = {
                            name(Strings.Subject)
                            id(ContactFormStyleSheet.SubjectId)
                            classes(ContactFormStyleSheet.DefaultInput, ContactFormStyleSheet.SubjectInput)
                            placeholder(Strings.SubjectPlaceholder)
                            required()
                        }
                    )
                }

                Div(attrs = { classes(ContactFormStyleSheet.InputContainer) }) {
                    Label(
                        forId = ContactFormStyleSheet.MessageId,
                        attrs = { classes(ContactFormStyleSheet.InputLabel) }) { Text(Strings.Message) }
                    TextArea(
                        attrs = {
                            name("body")
                            id(ContactFormStyleSheet.MessageId)
                            classes(ContactFormStyleSheet.DefaultInput, ContactFormStyleSheet.MessageInput)
                            placeholder(Strings.MessagePlaceholder)
                            required()
                        }
                    )
                }

                Input(
                    InputType.Submit,
                    attrs = {
                        classes(ComponentsStyleSheet.FilledButton, ComponentsStyleSheet.PrimaryButton)
                        value(Strings.Submit)
                    }
                )
            }
        }
    }
}