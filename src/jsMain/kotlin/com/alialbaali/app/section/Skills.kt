package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.model.Skill
import com.alialbaali.app.theme.SkillsStyleSheet
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Section

@Composable
fun Skills() {
    val skills = remember { Skill.values() }
    Section(attrs = { classes(SkillsStyleSheet.Section) }) {
        Div(attrs = { classes(SkillsStyleSheet.Container) }) {
            skills.forEach { skill ->
                SkillItem(skill)
            }
        }
    }
}

@Composable
private fun SkillItem(skill: Skill) {
    Div(
        attrs = {
            title(skill.name)
            classes(SkillsStyleSheet.Item)
        }
    ) {
        Img(src = skill.imagePath, alt = skill.name, attrs = { classes(SkillsStyleSheet.Image) })
    }
}