package nav

import dev.fritz2.components.box
import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import utils.*

fun RenderContext.sidebar() {
    flexBox({
        height { 100.per }
        width { 5.per }
        direction { column }
        alignItems { center }
        justifyContent { flexEnd }
        position {
            fixed {
                left { 0.px }
                right { auto }
                bottom { 0.px }
            }
        }
    }) {
        linkIcon(
            styling = {
                paddings { vertical { normal } }
            },
            definition = WebsiteIcons.Github,
            url = WebsiteLinks.Github
        )
        linkIcon(
            styling = {
                paddings { vertical { normal } }
            },
            definition = WebsiteIcons.Linkedin,
            url = WebsiteLinks.Linkedin
        )
        linkIcon(
            styling = {
                paddings { vertical { normal } }
            },
            definition = WebsiteIcons.Twitter,
            url = WebsiteLinks.Twitter
        )

        box({
            margins {
                top { normal }
            }
            border {
                width { 2.px }
                color { neutral.mainContrast }
            }
            radii {
                top { full }
            }
            height { 100.px }
        }) {

        }
    }

}
