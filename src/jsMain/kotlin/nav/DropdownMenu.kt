package nav

import dev.fritz2.binding.SimpleHandler
import dev.fritz2.components.MenuComponent
import dev.fritz2.components.box
import dev.fritz2.components.dropdown
import dev.fritz2.components.menu
import dev.fritz2.dom.html.RenderContext
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions
import utils.*

@OptIn(DelicateCoroutinesApi::class)
fun RenderContext.dropdownMenu() {
    box({
        width { 100.per }
        position {
            fixed {
                top { 0.px }
            }
        }
        background {
            color { neutral.main }
        }
        flex {
            alignSelf { flexStart }
        }
        paddings {
            vertical { normal }
        }
        zIndex { "1" }
    }) {
        dropdown({
            width { 90.per }
        }) {
            content { menu() }
        }
    }
}

private fun RenderContext.menu() {
    menu({
        height { 100.per }
    }) {
        entries()
        custom({
            margins {
                vertical { normal }
            }
        }
        ) { links() }
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun MenuComponent.entries() {
    Section.values().forEach { section ->
        entry({
            fontSize { normal }
            width { 100.per }
            color { primary.main }
        }) {
            text(section.name)
            events {
                clicks.map { section } handledBy SimpleHandler { flow, _ ->
                    flow.onEach {
                        when (it) {
                            Section.About -> window.scroll(ScrollToOptions(top = 800.0, behavior = ScrollBehavior.SMOOTH))
                            Section.Skills -> window.scroll(ScrollToOptions(top = 2100.0, behavior = ScrollBehavior.SMOOTH))
                            Section.Portfolio -> window.scroll(ScrollToOptions(top = 2980.0, behavior = ScrollBehavior.SMOOTH))
                        }
                    }.launchIn(GlobalScope)
                }
            }
        }
    }
}

private fun RenderContext.links() {
    linkIcon(
        styling = {
            paddings { right { normal } }
        },
        definition = WebsiteIcons.Github,
        url = WebsiteLinks.Github
    )
    linkIcon(
        styling = {
            paddings { right { normal } }
        },
        definition = WebsiteIcons.Linkedin,
        url = WebsiteLinks.Linkedin
    )
    linkIcon(
        styling = {
            paddings { right { normal } }
        },
        definition = WebsiteIcons.Twitter,
        url = WebsiteLinks.Twitter
    )
}