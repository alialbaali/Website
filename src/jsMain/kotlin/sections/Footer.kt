package sections

import dev.fritz2.components.box
import dev.fritz2.dom.html.RenderContext
import kotlin.js.Date

fun RenderContext.footer() {
    box({
        margin { normal }
        textAlign { center }
    }) {
        +"${Date().getFullYear()} © Ali Albaali — One step at a time"
    }
}