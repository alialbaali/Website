package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Project
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Technology
import com.alialbaali.app.theme.style.PortfolioStyleSheet
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun Portfolio() {
    Section(attrs = { classes(PortfolioStyleSheet.Section) }) {
        SectionName(Section.Portfolio)
        Div(attrs = { classes(PortfolioStyleSheet.Container) }) {
            HighlightedProject(Project.Noto)
            HighlightedProject(Project.Kamel)
            Project(Project.ChatyChaty)
            Project(Project.CastingAgency)
            Project(Project.Minigrep)
            Project(Project.Shopally)
            Project(Project.Website)
        }
    }
}

@Composable
private fun HighlightedProject(project: Project) {
    Article(attrs = { classes(PortfolioStyleSheet.HighlightedProject) }) {
        Aside(attrs = { classes(PortfolioStyleSheet.HighlightedProjectInfo) }) {
            HighlightedProjectHeader(project)
            HighlightedProjectDescription(project)
        }
        Img(src = project.imagePath!!, alt = project.name, attrs = { classes(PortfolioStyleSheet.HighlightedProjectImage) })
    }
}

@Composable
private fun Project(project: Project) {
    Article(attrs = { classes(PortfolioStyleSheet.Project) }) {
        HighlightedProjectHeader(project)
        HighlightedProjectDescription(project)
    }
}

@Composable
private fun HighlightedProjectHeader(project: Project) {
    Header(attrs = { classes(PortfolioStyleSheet.HighlightedProjectHeader) }) {
        Span(attrs = { classes(PortfolioStyleSheet.HighlightedProjectName) }) {
            Text(project.name)
        }
        Div(attrs = { classes(PortfolioStyleSheet.TechnologiesContainer) }) {
            project.technologies.forEach { TechnologyItem(it) }
        }
    }
}

@Composable
private fun HighlightedProjectDescription(project: Project) {
    P(attrs = { classes(PortfolioStyleSheet.HighlightedProjectDescription) }) {
        Text(project.description)
    }
}

@Composable
private fun TechnologyItem(technology: Technology) {
    val color = remember(technology) { Color(technology.color) }
    Span(
        attrs = {
            classes(PortfolioStyleSheet.TechnologyName)
            style {
                color(color)
                border(2.px, LineStyle.Solid, color)
            }
        }
    ) {
        Text(technology.name)
    }
}