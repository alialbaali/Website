package sections

import dev.fritz2.components.flexBox
import dev.fritz2.components.tooltip
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.img
import models.Skill
import surface
import utils.per
import utils.rem
import utils.vh

fun RenderContext.skills() {
    flexBox({
        minHeight(md = { 85.vh })
        justifyContent { center }
        alignItems { flexStart }
        alignContent { center }
        margins(
            sm = {
                bottom { 8.rem }
            }
        )
    }) {
        flexBox({
            padding { normal }
            radius { giant }
            background {
                color { surface }
            }
            alignItems { center }
            justifyContent { center }
            alignContent { center }
            width { 100.per }
            wrap { wrap }
        }) {
            Skill.values().forEach { skill ->
                skill(skill)
            }
        }
    }
}

private fun RenderContext.skill(skill: Skill) {
    img({
        tooltip(skill.name)()
        width(sm = { 30.per }, md = { 13.per })
        padding { normal }
        margins(
            sm = {
                vertical { small }
            },
            md = {
                vertical { large }
                horizontal { huge }
            }
        )
        hover {
            css(
                """
                transform: translateY(-5px);
                transition: all 0.5s cubic-bezier(0, 0, 0, 1);
                """.trimIndent()
            )
        }
    }) {
        src(skill.path)
        alt(skill.name)
    }
}