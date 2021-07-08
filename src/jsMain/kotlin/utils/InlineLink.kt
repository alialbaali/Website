package utils

import WebsiteTheme
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.a
import dev.fritz2.styling.params.rgba

fun RenderContext.inlineLink(text: String, url: String) {
    a({
        hover {
            css("text-decoration: underline 0.1rem")
            css("text-underline-offset: 0.5rem")
            css("text-decoration-color:${WebsiteTheme.colors.info.main}")
        }
        css("text-decoration-color:${rgba(255, 221, 210, 0.0)}")
        transition(property = { "text-decoration-color" })
        color { info.main }
    }) {
        target("_blank")
        href(url)
        +text
    }
}
