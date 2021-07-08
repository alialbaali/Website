package sections

import dev.fritz2.components.box
import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.params.ColorProperty
import dev.fritz2.styling.theme.Theme
import models.Project
import surface
import utils.linkIcon
import utils.per
import utils.px
import utils.transition

fun RenderContext.project(project: Project) {
    flexBox(
        {
            margins(
                sm = {
                    bottom { normal }
                },
                md = {
                    right { normal }
                    bottom { normal }
                }
            )
            padding(sm = { small }, md = { normal })
            direction { column }
            justifyContent { flexStart }
            alignItems { flexStart }
            boxShadow { raised }
            radius { giant }
            background {
                color { surface }
            }
            width(sm = { 100.per }, md = { 50.per })
            flex {
                basis { 30.per }
            }
            hover {
                boxShadow { raisedFurther }
                css("transform: translateY(-5px)")
                transition()
            }
            alignContent { center }
            minHeight { 300.px }
        }
    ) {
        info(project)
        stack(project.stack)
        description(project.description)
    }

}

private fun RenderContext.info(project: Project) {
    flexBox({
        justifyContent { flexEnd }
        alignItems { center }
        width { 100.per }
    }) {
        title(project.name)
        project.link?.let {
            linkIcon(
                styling = {
                    paddings {
                        horizontal { smaller }
                    }
                },
                url = it,
                definition = utils.WebsiteIcons.Link
            )
        }
        project.githubLink?.let {
            linkIcon(
                styling = {
                    paddings {
                        horizontal { smaller }
                    }
                },
                url = it,
                definition = utils.WebsiteIcons.Github
            )
        }
        year(project.year.toString())
    }
}

private fun RenderContext.title(name: String) {
    box({
        fontSize(sm = { larger }, md = { larger })
        fontWeight { semiBold }
        margins {
            right { auto }
        }
    }) {
        +name
    }
}

private fun RenderContext.year(year: String) {
    box({
        borders {
            bottom {
                width { 0.5.px }
                color { gray50 }
                style { groove }
            }
        }
        margins {
            left { smaller }
        }
        fontStyle { italic }
//                css("transform: rotate(90deg)")
    }) {
        +year
    }
}

private fun RenderContext.stack(technologies: List<String>) {
    val colors = mutableMapOf<String, ColorProperty>().apply {
        put("Kotlin", "#E040FB")
        put("Python", "#536DFE")
        put("Android", "#69F0AE")
        put("Flask", "#18FFFF")
        put("HTML", "#EEFF41")
        put("CSS", "#FFAB40")
        put("Ktor", "#FF5252")
        put("Compose", "#64FFDA")
        put("Rust", "#B2FF59")
    }

    flexBox({
        direction { row }
        width { 100.per }
        wrap { wrap }
    }) {
        technologies.forEach { tech ->
            val techColor = colors[tech] ?: Theme().colors.primary.main
            tech(tech, techColor)
        }
    }
}

private fun RenderContext.tech(tech: String, color: String) {
    box({
        border {
            width { 2.px }
            color { color }
        }
        paddings {
            horizontal { normal }
            vertical { tiny }
        }
        margins {
            top { smaller }
            right { smaller }
            bottom { smaller }
        }
        color { color }
        radius { giant }
        fontWeight { semiBold }
        fontSize { smaller }
    }) {
        +tech
    }
}

private fun RenderContext.description(description: String) {

    box({
        margins {
            top { normal }
        }
        fontSize(sm = { normal }, md = { normal })
    }) {
        +description
    }
}