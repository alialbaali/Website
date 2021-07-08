package sections

import WebsiteTheme
import dev.fritz2.components.box
import dev.fritz2.components.flexBox
import dev.fritz2.components.icon
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.params.rgba
import models.Project
import utils.*

fun RenderContext.portfolio() {
    flexBox({
        height(md = { 85.vh })
        direction(sm = { column }, md = { row })
        justifyContent { center }
        alignItems { center }
        alignContent { flexStart }
        wrap(sm = { nowrap }, md = { wrap })
        margins(
            sm = {
                bottom { 8.rem }
            }
        )
    }) {
        project(Project.Kamel)
        project(Project.Minigrep)
        project(Project.ShoppingAPI)
        project(Project.Website)
        project(Project.CastingAgency)
        project(Project.ChatyChaty)
        viewMoreButton()
    }
}

private fun RenderContext.viewMoreButton() {
    a {
        box({
            hover {
                css("text-decoration: underline 0.1rem")
                css("text-underline-offset: 0.5rem")
                css("text-decoration-color:${WebsiteTheme.colors.primary.main}")
            }
            css("text-decoration-color:${rgba(0, 109, 119, 0.0)}")
            transition(property = { "text-decoration-color" })
            color { primary.main }
            fontSize { normal }
            fontWeight { medium }
        }) {
            +"View more"
            icon {
                fromTheme { chevronRight }
            }
        }
        href(WebsiteLinks.GithubRepositories)
        target("_blank")
    }
}