package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.components.SectionName
import com.alialbaali.app.model.Project
import com.alialbaali.app.model.Section
import com.alialbaali.app.model.Strings
import com.alialbaali.app.model.Technology
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import com.alialbaali.app.theme.style.PortfolioStyleSheet
import com.alialbaali.app.util.*
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun Portfolio() {
    Section(attrs = { classes(PortfolioStyleSheet.Section) }) {
        SectionName(Section.Portfolio)
        Div(attrs = { classes(PortfolioStyleSheet.Container) }) {
            Project.All.forEach { project ->
                if (project.isHighlighted) HighlightedProject(project) else Project(project)
            }
        }
    }
}

@Composable
private fun HighlightedProject(project: Project) {
    Article(attrs = { classes(ComponentsStyleSheet.Card, PortfolioStyleSheet.HighlightedProjectContainer) }) {
        Aside(attrs = { classes(PortfolioStyleSheet.HighlightedProjectInfoContainer) }) {
            ProjectInfo(project)
            ProjectActions(project)
        }
        Img(
            src = project.imagePath!!,
            alt = project.title,
            attrs = {
                classes(PortfolioStyleSheet.HighlightedProjectImage)
                style { backgroundColor(project.imageBackgroundCssColor) }
            }
        )
    }
}

@Composable
private fun Project(project: Project) {
    Article(attrs = { classes(ComponentsStyleSheet.Card, PortfolioStyleSheet.ProjectContainer) }) {
        ProjectInfo(project)
        ProjectActions(project)
    }
}

@Composable
private fun ProjectInfo(project: Project) {
    Div(attrs = { classes(PortfolioStyleSheet.ProjectInfo) }) {
        ProjectHeader(project)
        ProjectDescription(project)
    }
}

@Composable
private fun ProjectHeader(project: Project) {
    val projectYear = remember(project) { project.yearAsString }
    Header(attrs = { classes(PortfolioStyleSheet.ProjectHeader) }) {
        Div(attrs = { classes(PortfolioStyleSheet.ProjectTitleContainer) }) {
            Span(attrs = { classes(PortfolioStyleSheet.ProjectTitle) }) { Text(project.title) }
            Span(attrs = { classes(PortfolioStyleSheet.ProjectYear) }) { Text(projectYear) }
        }
        Span(attrs = { classes(PortfolioStyleSheet.ProjectSubtitle) }) { Text(project.subtitle) }
        Div(attrs = { classes(PortfolioStyleSheet.TechnologiesContainer) }) {
            project.technologies.forEach { TechnologyItem(it) }
        }
    }
}

@Composable
private fun ProjectDescription(project: Project) {
    P(attrs = { classes(PortfolioStyleSheet.ProjectDescription) }) { Text(project.description) }
    Ul(attrs = { classes(PortfolioStyleSheet.ProjectFeatureContainer) }) {
        project.features.forEach { feature -> Li { Text(feature) } }
    }
}

@Composable
private fun ProjectActions(project: Project) {
    Div(attrs = { classes(PortfolioStyleSheet.ActionsContainer) }) {
        A(
            attrs = {
                href(project.githubLink)
                target(ATarget.Blank)
                classes(ComponentsStyleSheet.TextButton, ComponentsStyleSheet.PrimaryButton)
            }
        ) {
            Text(Strings.LearnMore)
            I(attrs = { feather("external-link") })
        }
    }
}

@Composable
private fun TechnologyItem(technology: Technology) {
    val lightColor = remember(technology) { technology.lightCSSColor }
    val darkColor = remember(technology) { technology.darkCSSColor }
    val themeBasedColor = if (window.isSystemInDarkMode()) lightColor else darkColor
    Span(
        attrs = {
            classes(PortfolioStyleSheet.TechnologyItem)
            style {
                color(themeBasedColor)
                border(2.px, LineStyle.Solid, themeBasedColor)
            }
        }
    ) {
        Text(technology.title)
    }
}