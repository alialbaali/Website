package utils

import dev.fritz2.components.icon
import dev.fritz2.components.tooltip
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.a
import dev.fritz2.styling.params.BoxParams
import dev.fritz2.styling.theme.IconDefinition

fun RenderContext.linkIcon(styling: BoxParams.() -> Unit = {}, definition: IconDefinition, url: String) {
    a({
        tooltip(definition.displayName)()
        hover {
            color { secondary.main }
            css("transform: translateY(-5px);")
            transition()
        }
        styling()
    }) {
        href(url)
        target("_blank")
        icon {
            def(definition)
        }
    }
}
