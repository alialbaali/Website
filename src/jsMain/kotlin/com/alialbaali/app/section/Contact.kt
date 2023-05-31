package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import com.alialbaali.app.theme.style.ContactStyleSheet
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.required
import org.jetbrains.compose.web.dom.*

@Composable
fun Contact() {
    Section(attrs = { classes(ContactStyleSheet.Section) }) {
//        SectionName(Section.Contact)
        Div(attrs = { classes(ContactStyleSheet.Container) }) {
            Div(attrs = { classes(ContactStyleSheet.Info) }) {
                Span(attrs = { classes(ContactStyleSheet.InfoText) }) { Text(Strings.ContactInfoTitle) }
                Span(attrs = { classes(ContactStyleSheet.InfoText) }) { Text(Strings.ContactInfoGetInTouch) }
            }

            Form(attrs = { classes(ComponentsStyleSheet.Card, ContactStyleSheet.Form) }, action = Links.Mail) {
                Div(attrs = { classes(ContactStyleSheet.InputContainer) }) {
                    Label(forId = ContactStyleSheet.EmailId, attrs = { classes(ContactStyleSheet.InputLabel) }) { Text(Strings.Email) }
                    Input(
                        InputType.Email,
                        attrs = {
                            id(ContactStyleSheet.EmailId)
                            name(Strings.Email)
                            classes(ContactStyleSheet.DefaultInput, ContactStyleSheet.EmailInput)
                            placeholder(Strings.EmailPlaceholder)
                            required()
                        }
                    )
                }

                Div(attrs = { classes(ContactStyleSheet.InputContainer) }) {
                    Label(forId = ContactStyleSheet.SubjectId, attrs = { classes(ContactStyleSheet.InputLabel) }) { Text(Strings.Subject) }
                    Input(
                        InputType.Text,
                        attrs = {
                            name(Strings.Subject)
                            id(ContactStyleSheet.SubjectId)
                            classes(ContactStyleSheet.DefaultInput, ContactStyleSheet.SubjectInput)
                            placeholder(Strings.SubjectPlaceholder)
                            required()
                        }
                    )
                }

                Div(attrs = { classes(ContactStyleSheet.InputContainer) }) {
                    Label(forId = ContactStyleSheet.MessageId, attrs = { classes(ContactStyleSheet.InputLabel) }) { Text(Strings.Message) }
                    TextArea(
                        attrs = {
                            name("body")
                            id(ContactStyleSheet.MessageId)
                            classes(ContactStyleSheet.DefaultInput, ContactStyleSheet.MessageInput)
                            placeholder(Strings.MessagePlaceholder)
                            required()
                        }
                    )
                }

                Input(
                    InputType.Submit,
                    attrs = {
                        classes(ComponentsStyleSheet.BaseButton, ComponentsStyleSheet.FilledButton)
                        value(Strings.Submit)
                    }
                )
            }
        }
    }
}