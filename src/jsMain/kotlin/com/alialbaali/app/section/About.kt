package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.components.HighlightedText
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Section
import com.alialbaali.app.theme.style.AboutStyleSheet
import org.jetbrains.compose.web.dom.*

@Composable
fun About() {
    Section(attrs = { classes(AboutStyleSheet.Section) }) {
        SectionName(Section.About)
        Div(attrs = { classes(AboutStyleSheet.Container) }) {
            Img(src = "images/Me.png", attrs = { classes(AboutStyleSheet.Image) })
            P(attrs = { classes(AboutStyleSheet.Text) }) {
                Text(
                    "Hello! My name is Ali. I began my journey almost 3 years ago, " +
                            "when I started learning Java and Android development through online courses. " +
                            "After a while I made my way to Kotlin and started exploring backend programming with "
                )
                HighlightedText("Ktor", "https://ktor.io/")
                Text(".")
                Br()
                Br()
                Text(
                    "Along the way, I picked up few other things such as SQL and Git. " +
                            "During that time, I also managed to build my first "
                )
                HighlightedText("personal website", "https://old.alialbaali.com")
                Text(" using only HTML and CSS.")
                Br()
                Br()
                Text("Last year, I had the chance to take a ")
                HighlightedText(
                    "Udacity nanodegree program",
                    "https://www.udacity.com/course/full-stack-web-developer-nanodegree--nd0044"
                )
                Text(
                    " which helped increasing my backend programming knowledge " +
                            "by developing applications using Python, Flask and other tools and have earned a "
                )
                HighlightedText("certificate", "https://graduation.udacity.com/confirm/N72UE3J")
                Br()
                Br()
                Text("Currently, I'm learning and exploring Rust, Compose and Inkscape.")
            }
        }
    }
}