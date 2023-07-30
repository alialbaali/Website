package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Category
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Technology
import com.alialbaali.app.style.ComponentsStyleSheet
import com.alialbaali.app.style.SkillsStyleSheet
import com.alialbaali.app.util.themeStatus
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.*

@Composable
fun Skills() {
    val categories = Category.entries
    Section(attrs = { classes(SkillsStyleSheet.Section) }) {
        SectionName(Section.Skills)
        Div(attrs = { classes(SkillsStyleSheet.Container) }) {
            categories.forEach { category -> CategoryItem(category) }
        }
    }
}

@Composable
private fun CategoryItem(category: Category) {
    Article(attrs = { classes(ComponentsStyleSheet.Card, SkillsStyleSheet.CategoryItem) }) {
        Span(attrs = { classes(SkillsStyleSheet.CategoryTitle) }) { Text(category.title) }
        Hr(attrs = { classes(SkillsStyleSheet.CategoryDivider) })
        Div(attrs = { classes(SkillsStyleSheet.TechnologiesContainer) }) {
            category.content.forEach { technology -> TechnologyItem(technology) }
        }
    }
}

@Composable
private fun TechnologyItem(technology: Technology) {
    val technologyIcon = if (window.themeStatus.isDark) technology.lightIconUrl else technology.darkIconUrl
    Div(attrs = { classes(SkillsStyleSheet.TechnologyItem) }) {
        Img(src = technologyIcon, alt = technology.title, attrs = { classes(SkillsStyleSheet.TechnologyImage) })
        Span(attrs = { classes(SkillsStyleSheet.TechnologyTitle) }) { Text(technology.title) }
    }
}