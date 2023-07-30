package com.alialbaali.app.model

import com.alialbaali.app.model.Technology.*
import kotlin.js.Date

data class Project(
    val title: String,
    val subtitle: String,
    val description: String,
    val technologies: List<Technology>,
    val year: UInt,
    val link: String? = null,
    val githubLink: String,
    val imagePath: String? = null,
    val imageBackgroundColor: String? = null,
    val features: List<String> = emptyList(),
) {

    val isHighlighted get() = imagePath != null

    companion object {

        val Noto = Project(
            title = Strings.Noto.Title,
            subtitle = Strings.Noto.Subtitle,
            description = Strings.Noto.Description,
            technologies = listOf(Kotlin, SQL, Android, Compose, Supabase, Figma),
            githubLink = Links.GitHub.Noto,
            link = Links.Noto,
            year = Date().getFullYear().toUInt(),
            imagePath = "images/Noto.svg",
            imageBackgroundColor = "FFFFFF",
            features = Strings.Noto.Features,
        )

        val Kamel = Project(
            title = Strings.Kamel.Title,
            subtitle = Strings.Kamel.Subtitle,
            description = Strings.Kamel.Description,
            technologies = listOf(Kotlin, Compose, Ktor, Maven),
            githubLink = Links.GitHub.Kamel,
            year = Date().getFullYear().toUInt(),
            imagePath = "images/Kamel.svg",
            imageBackgroundColor = "263238"
        )

        val ChatyChaty = Project(
            title = Strings.ChatyChaty.Title,
            subtitle = Strings.ChatyChaty.Subtitle,
            description = Strings.ChatyChaty.Description,
            technologies = listOf(Kotlin, SQL, Android, Figma),
            githubLink = Links.GitHub.ChatyChaty,
            year = 2020U,
        )

        val CastingAgency = Project(
            title = Strings.CastingAgency.Title,
            subtitle = Strings.CastingAgency.Subtitle,
            description = Strings.CastingAgency.Description,
            technologies = listOf(Python, SQL, Flask, Docker),
            githubLink = Links.GitHub.CastingAgency,
            year = 2020U,
        )

        val Shopally = Project(
            title = Strings.Shopally.Title,
            subtitle = Strings.Shopally.Subtitle,
            description = Strings.Shopally.Description,
            technologies = listOf(Kotlin, SQL, Ktor, Docker, Heroku),
            githubLink = Links.GitHub.Shopally,
            year = 2020U,
            features = Strings.Shopally.Features,
        )

        val Website = Project(
            title = Strings.Website.Title,
            subtitle = Strings.Website.Subtitle,
            description = Strings.Website.Description,
            technologies = listOf(Kotlin, HTML, CSS, Netlify, Figma),
            githubLink = Links.GitHub.Website,
            year = Date().getFullYear().toUInt(),
        )

        val Minigrep = Project(
            title = Strings.Minigrep.Title,
            subtitle = Strings.Minigrep.Subtitle,
            description = Strings.Minigrep.Description,
            technologies = listOf(Rust, Linux),
            githubLink = Links.GitHub.Minigrep,
            year = 2021U,
        )

        val All = listOf(Noto, Kamel, ChatyChaty, Shopally, Website, CastingAgency, Minigrep)
    }
}
