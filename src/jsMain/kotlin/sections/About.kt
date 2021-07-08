package sections

import dev.fritz2.components.box
import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.img
import utils.inlineLink
import utils.per
import utils.rem
import utils.vh

fun RenderContext.about() {
    flexBox({
        height(md = { 65.vh })
        justifyContent { center }
        alignItems { flexStart }
        alignContent { center }
        margins(
            sm = {
                bottom { 8.rem }
            }
        )
    }) {
        flexBox({
            direction(sm = { column }, md = { row })
            radius { huge }
        }) {
            image()
            text()
        }
    }
}

private fun RenderContext.image() {
    img({
        width(sm = { 100.per }, md = { 30.per })
        radius { giant }
        margins(
            sm = {
                bottom { larger }
            },
            md = {
                right { larger }
            }
        )
        css("object-fit:cover")
    }) {
        src("Me.jpg")
    }
}

private fun RenderContext.text() {
    box({
        width(sm = { 100.per }, md = { 70.per })
        fontSize(sm = { normal }, md = { large })
        color { tertiary.main }
    }) {
        +("Hello! My name is Ali. I began my journey almost 3 years ago, " +
                "when I started learning Java and Android development through online courses. " +
                "After a while I made my way to Kotlin and started exploring backend programming with ")
        inlineLink("Ktor", "https://ktor.io/")
        +"."
        br {}
        br {}
        +("Along the way, I picked up few other things such as SQL and Git. " +
                "During that time, I also managed to build my first ")
        inlineLink("personal website", "https://old.alialbaali.com")
        +" using only HTML and CSS."
        br {}
        br {}
        +("Last year, I had the chance to take a ")
        inlineLink(
            "Udacity nanodegree program",
            "https://www.udacity.com/course/full-stack-web-developer-nanodegree--nd0044"
        )
        +(" which helped increasing my backend programming knowledge " +
                "by developing applications using Python, Flask and other tools and have earned a ")
        inlineLink("certificate", "https://graduation.udacity.com/confirm/N72UE3J")
        br {}
        br {}
        +("Currently, I'm learning and exploring Rust, Compose and Inkscape.")
    }
}
