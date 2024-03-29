package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alialbaali.app.components.HighlightedText
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Links
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.style.AboutStyleSheet
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.theme.Theme
import com.alialbaali.app.util.themeStatusAsFlow
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun About() {
    val themeStatus by window.themeStatusAsFlow().collectAsState(Theme.Status.Light)
    val imageUrl = if (themeStatus.isDark) "images/Coder-Light.svg" else "images/Coder-Dark.svg"
    Section(attrs = { classes(AboutStyleSheet.Section) }) {
        SectionName(Section.About)
        Div(attrs = { classes(ComponentsStyleSheet.Card, AboutStyleSheet.Container) }) {
            Img(src = imageUrl, attrs = { classes(AboutStyleSheet.Image) })
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