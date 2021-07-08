package sections

import dev.fritz2.binding.SimpleHandler
import dev.fritz2.components.clickButton
import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.a
import dev.fritz2.styling.h1
import dev.fritz2.styling.h2
import dev.fritz2.styling.h4
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions
import utils.WebsiteLinks
import utils.per
import utils.rem
import utils.vh

fun RenderContext.intro() {
    flexBox({
        height { 100.vh }
        justifyContent { center }
        alignItems { center }
        alignContent { flexStart }
    }) {
        flexBox({
            direction { column }
        }) {
            text()
            buttons()
        }
    }

}

private fun RenderContext.text() {
    h4({
        fontSize(sm = { large }, md = { huge })
        color { tertiary.main }
    }) {
        +"Hi there,"
    }

    h1({
        fontSize(sm = { huge }, md = { 6.rem })
        fontWeight { medium }
    }) {
        +"I'm Ali. I'm a software engineer and designer."
    }

    h2({
        width(md = { 75.per })
        fontSize(sm = { large }, md = { huge })
        fontWeight { medium }
        color { info.main }
        margins(
            sm = {
                top { huge }
            },
            md = {
                top { giant }
            },
        )
    }) {
        +"I like to build cool things that live on the internet using modern tools and technologies."
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun RenderContext.buttons() {
    flexBox({
        margins(
            sm = {
                top { huge }
            },
            md = {
                top { giant }
            },
        )
    }) {

        a({
            margins {
                right { normal }
            }
        }) {
            href(WebsiteLinks.Mail)
            target("_blank")
            clickButton({
                fontSize(sm = { normal }, md = { large })
            }) {
                variant { solid }
                size { large }
                text("Contact")
            }
        }

        clickButton({
            margins {
                left { normal }
            }
            fontSize(sm = { normal }, md = { large })
        }) {
            type { secondary }
            variant { outline }
            size { large }
            text("View portfolio")
        } handledBy SimpleHandler { flow, _ ->
            flow
                .onEach { window.scroll(ScrollToOptions(top = 3000.0, behavior = ScrollBehavior.SMOOTH)) }
                .launchIn(GlobalScope)
        }
    }
}