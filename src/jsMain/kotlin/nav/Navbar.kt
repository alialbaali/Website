package nav

import dev.fritz2.binding.SimpleHandler
import dev.fritz2.components.clickButton
import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions
import utils.per
import utils.px

@OptIn(DelicateCoroutinesApi::class)
fun RenderContext.navbar() {
    flexBox({
        width { 100.per }
        justifyContent { center }
        alignItems { center }
        position {
            fixed {
                top { 0.px }
            }
        }
        background {
            color { neutral.main }
        }
        paddings {
            vertical { normal }
        }
        zIndex { "1" }
    }) {
        Page.values().forEach { page ->
            clickButton({
                margins {
                    horizontal { normal }
                }
            }) {
                text(page.name)
                variant { ghost }
                size { small }
            }.map { page } handledBy SimpleHandler { flow, _ ->
                flow.onEach { page ->
                    when (page) {
                        Page.About -> window.scroll(ScrollToOptions(top = 850.0, behavior = ScrollBehavior.SMOOTH))
                        Page.Skills -> window.scroll(ScrollToOptions(top = 1950.0, behavior = ScrollBehavior.SMOOTH))
                        Page.Portfolio -> window.scroll(ScrollToOptions(top = 3000.0, behavior = ScrollBehavior.SMOOTH))
                    }
                }.launchIn(GlobalScope)
            }
        }
    }
}