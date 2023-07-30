package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.components.HighlightedText
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.theme.style.AboutStyleSheet
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import org.jetbrains.compose.web.dom.*

@Composable
fun About() {
    Section(attrs = { classes(AboutStyleSheet.Section) }) {
        SectionName(Section.About)
        Div(attrs = { classes(ComponentsStyleSheet.Card, AboutStyleSheet.Container) }) {
            Img(src = "images/Coder.svg", attrs = { classes(AboutStyleSheet.Image) })
            P(attrs = { classes(AboutStyleSheet.Text) }) {
                Text(Strings.About[0])
                Text(" ")
                HighlightedText(Strings.Ktor, Links.Ktor)
                Text(".")
                Br()
                Br()
                Text(Strings.About[1])
                Text(" ")
                HighlightedText(Strings.PersonalWebsite, Links.WebsiteV1)
                Text(" ")
                Text(Strings.About[2])
                Br()
                Br()
                Text(Strings.About[3])
                Text(" ")
                HighlightedText(Strings.UdacityNanodegreeProgram, Links.UdacityNanodegreeProgram)
                Text(" ")
                Text(Strings.About[4])
                Text(" ")
                HighlightedText(Strings.Certificate, Links.Certificate)
                Text(".")
                Br()
                Br()
                Text(Strings.About[5])
                Text(" ")
                HighlightedText(Strings.Noto.Title, Links.Noto)
                Text(" & ")
                HighlightedText(Strings.Kamel.Title, Links.GitHub.Kamel)
                Text(", ")
                Text(Strings.About[6])
            }
        }
    }
}