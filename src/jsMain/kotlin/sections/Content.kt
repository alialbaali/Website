package sections

import dev.fritz2.components.box
import dev.fritz2.dom.html.RenderContext
import utils.per

fun RenderContext.content() {
    box({
        width(sm = { 90.per }, md = { 75.per })
        justifyContent { center }
        alignItems { center }
    }) {
        intro()
        sectionName("About")
        about()
        sectionName("Skills")
        skills()
        sectionName("Portfolio")
        portfolio()
//        sectionName("Contact")
//        contact()
        footer()
    }
}

private fun RenderContext.sectionName(name: String) {
    box({
        fontSize(sm = { huge }, md = { giant })
        fontWeight { bold }
        width { 100.per }
        textAlign { center }
        margins {
            bottom { normal }
        }
    }) {
        +name
    }
}