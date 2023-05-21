package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Technology
import com.alialbaali.app.theme.style.SkillsStyleSheet
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Section

@Composable
fun Skills() {
    val technologies = remember { Technology.values() }
    Section(attrs = { classes(SkillsStyleSheet.Section) }) {
        SectionName(Section.Skills)
        Div(attrs = { classes(SkillsStyleSheet.Container) }) {
            technologies.forEach { technology ->
                TechnologyItem(technology)
            }
        }
    }
}

@Composable
private fun TechnologyItem(technology: Technology) {
    Div(
        attrs = {
            title(technology.name)
            classes(SkillsStyleSheet.Item)
        }
    ) {
        Img(src = technology.imagePath, alt = technology.name, attrs = { classes(SkillsStyleSheet.Image) })
    }
}