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
        height(md = { 85.vh })
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
            Skill.All.forEach { skill ->
                skill(skill)
            }
        }
    }
}

private fun RenderContext.skill(skill: Skill) {
    img({
        tooltip(skill.name)()
        width(sm = { 30.per }, md = { 12.per })
        margins(
            sm = {
                horizontal { 1.per }
            },
            md = {
                horizontal { 3.per }
            }
        )
        padding { normal }
        hover {
            css(
                """
                transform: translateY(-5px);
                transition: all 0.5s cubic-bezier(0, 0, 0, 1);
                """.trimIndent()
            )
        }
    }) {
        src(skill.value)
        alt(skill.name)
    }
}