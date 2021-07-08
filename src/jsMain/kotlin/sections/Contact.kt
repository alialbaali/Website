package sections

import dev.fritz2.binding.RootStore
import dev.fritz2.components.box
import dev.fritz2.components.clickButton
import dev.fritz2.components.flexBox
import dev.fritz2.components.formControl
import dev.fritz2.components.validation.ComponentValidationMessage
import dev.fritz2.components.validation.ComponentValidator
import dev.fritz2.components.validation.WithValidator
import dev.fritz2.components.validation.errorMessage
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.identification.inspect
import dev.fritz2.lenses.buildLens
import models.Mail
import utils.per
import utils.vh

fun RenderContext.contact() {
    val mail = object : RootStore<Mail>(Mail("", "", "")), WithValidator<Mail, Unit> {
        override val validator: ComponentValidator<Mail, Unit> = MailValidator

        init {
            validate(Unit)
        }

        val send = handle<Unit> { mail, _ ->
//            if (validator.isValid(mail, Unit)) {
//
//            }
            mail
        }
    }

    val name = mail.sub(Lens.Name)
    val email = mail.sub(Lens.Email)
    val message = mail.sub(Lens.Message)

    box({
        height { 100.vh }
        width { 100.per }
        justifyContent { center }
        alignItems { center }
    }) {
        flexBox({
            direction { column }
            justifyContent { spaceEvenly }
            alignItems { center }
            background {
                color { gray700 }
            }
            width { 50.per }
            padding { normal }
            radius { normal }
            height { 50.per }
            margins {
                left { auto }
                right { auto }
            }
        }) {

            formControl({
                margin { auto }
                flex {
                    basis { 10.per }
                }
            }) {
                inputField({
                    fontWeight { semiBold }
                }, value = name) {
                    variant { outline }
                    placeholder("Name")
                }
            }

            formControl({
                margin { auto }
                flex {
                    basis { 10.per }
                }
            }) {
                inputField(
                    {
                        fontWeight { semiBold }
                    },
                    value = email
                ) {
                    variant { outline }
                    placeholder("Email")
                }
            }

            formControl({
                margin { auto }
                flex {
                    basis { 50.per }
                }
            }) {
                textArea({
                    fontWeight { medium }
                    height { 100.per }
                }, store = message) {
                    size { large }
                    resizeBehavior { none }
                    placeholder("Message")
                }
            }

            clickButton({
                width { 35.per }
                margins {
                    left { auto }
                    top { auto }
                }
            }) {
                text("Send")
            } handledBy mail.send
        }
    }
}

object Lens {
    val Name = buildLens<Mail, String>("name", { it.name }, { mail, name -> mail.copy(name = name) })
    val Email = buildLens<Mail, String>("email", { it.email }, { mail, email -> mail.copy(email = email) })
    val Message =
        buildLens<Mail, String>("message", { it.message }, { mail, message -> mail.copy(message = message) })

}


private object MailValidator : ComponentValidator<Mail, Unit>() {
    override fun validate(data: Mail, metadata: Unit): List<ComponentValidationMessage> {
        val messages = mutableListOf<ComponentValidationMessage>()

        val inspector = inspect(data)
        val name = inspector.sub(Lens.Name)
        val email = inspector.sub(Lens.Email)
        val message = inspector.sub(Lens.Message)

        if (name.data.isBlank()) messages.add(errorMessage(name.id, "Name is required"))

        if (email.data.isBlank()) messages.add(errorMessage(email.id, "Email is required"))
        else if (!email.data.matches(Regex("""^\S+@\S+\.\S+${'$'}""")))
            messages.add(
                errorMessage(
                    email.id,
                    "Email address is not valid. Email address should follow the format user@domain.com."
                )
            )

        if (message.data.isBlank()) messages.add(errorMessage(message.id, "Message is required"))

        return messages
    }
}