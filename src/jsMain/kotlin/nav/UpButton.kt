package nav

import dev.fritz2.binding.SimpleHandler
import dev.fritz2.binding.storeOf
import dev.fritz2.components.box
import dev.fritz2.components.icon
import dev.fritz2.dom.html.RenderContext
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions
import utils.px
import utils.transition

@OptIn(DelicateCoroutinesApi::class)
fun RenderContext.upButton() {
    val isScrolled = storeOf(false)

    window.onscroll = { isScrolled.update(window.scrollY > 500) }

    isScrolled.data.render { value ->
        box({
            position {
                fixed {
                    left { auto }
                    right { 0.px }
                    bottom { 0.px }
                }
            }
            margin(sm = { normal }, md = { huge })
            radius { full }
            padding { small }
            if (value) {
                css("cursor: pointer")
                opacity { "1" }
            } else {
                css("cursor: auto")
                opacity { "0" }
            }
            transition()
            background {
                color { primary.main }
            }
            color { primary.mainContrast }
            hover {
                background {
                    color { primary.highlight }
                }
                color { primary.highlightContrast }
            }
        }) {
            icon({
                size { huge }
            }) {
                fromTheme { chevronUp }
            }

            clicks handledBy SimpleHandler { flow, job ->
                flow
                    .onEach { window.scroll(ScrollToOptions(0.0, 0.0, ScrollBehavior.SMOOTH)) }
                    .launchIn(GlobalScope)
            }
        }
    }
}
