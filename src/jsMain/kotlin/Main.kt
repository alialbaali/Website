import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.theme.render
import kotlinx.browser.window
import nav.dropdownMenu
import nav.navbar
import nav.sidebar
import nav.upButton
import sections.content

fun main() = render(WebsiteTheme) { website() }

private fun RenderContext.website() {
    flexBox({
        direction { column }
        justifyContent { center }
        alignItems { center }
    }) {
        if (window.screen.width > 800) {
            navbar()
            sidebar()
        } else {
            dropdownMenu()
        }
        upButton()
        content()
    }
}