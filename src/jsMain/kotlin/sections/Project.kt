package sections

import dev.fritz2.components.box
import dev.fritz2.components.flexBox
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.params.FlexParams
import models.Project
import models.Technology
import surface
import utils.*

fun RenderContext.project(project: Project) {
    flexBox({ projectparams() }) {
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
                definition = WebsiteIcons.Link
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
                definition = WebsiteIcons.Github
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

private fun RenderContext.stack(technologies: List<Technology>) {
    flexBox({
        direction { row }
        width { 100.per }
        wrap { wrap }
    }) {
        technologies.forEach { tech ->
            tech(tech)
        }
    }
}

private fun RenderContext.tech(technology: Technology) {
    box({
        border {
            width { 2.px }
            color { technology.color }
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
        color { technology.color }
        radius { giant }
        fontWeight { medium }
        fontSize { small }
    }) {
        +technology.name
    }
}

private fun RenderContext.description(description: String) {
    box({
        margins {
            top { normal }
        }
        fontSize(sm = { normal }, md = { normal })
    }) {
//        val text = storeOf(description)
//        links.forEach {
//            text.update(text.current.replaceAfter(it.key, ""))
//            inlineLink(it.key, it.value)
//            text.update(text.current + description)
//        }
//        +text.current
        +description
    }
}

private fun FlexParams.projectparams() {
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

fun RenderContext.chatychaty() {
    val project = Project.ChatyChaty
    flexBox({ projectparams() }) {
        info(project)
        stack(project.stack)
        chatychatyDescription()
    }
}

private fun RenderContext.chatychatyDescription() {
    box({
        margins {
            top { normal }
        }
        fontSize(sm = { normal }, md = { normal })
    }) {
        +"Chats application developed using Kotlin, while the "
        inlineLink("backend", "https://github.com/Yousif-FJ/ChatyChaty")
        +" is implemented using C# by my friend "
        inlineLink("Yousif", "https://github.com/Yousif-FJ")
        +". It features real-time communication, archived and pinned chats, dark mode and more."
    }
}

fun RenderContext.website() {
    val project = Project.Website
    flexBox({ projectparams() }) {
        info(project)
        stack(project.stack)
        websiteDescription()
    }
}

private fun RenderContext.websiteDescription() {
    box({
        margins {
            top { normal }
        }
        fontSize(sm = { normal }, md = { normal })
    }) {
        +"My personal website built using "
        inlineLink("Kotlin/JS", "https://kotlinlang.org/docs/js-overview.html")
        +" by leveraging "
        inlineLink("fritz2", "https://www.fritz2.dev/")
        +" framework in this version and HTML and CSS in the previous one."
    }
}