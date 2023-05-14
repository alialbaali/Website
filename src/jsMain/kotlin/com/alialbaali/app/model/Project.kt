package com.alialbaali.app.model

import com.alialbaali.app.model.Technology.*


data class Project(
    val name: String,
    val description: String,
    val technologies: List<Technology>,
    val year: UInt,
    val link: String? = null,
    val githubLink: String? = null,
    val imagePath: String? = null,
) {
    companion object {

        val Kamel = Project(
            name = "Kamel",
            description = "Multi-platform asynchronous media loading library for Compose." +
                    " It provides simple and efficient way to load, cache, and display images using Ktor client on Desktop and Android.",
            technologies = listOf(Kotlin, Compose),
            githubLink = "https://github.com/alialbaali/Kamel",
            year = 2021U,
            imagePath = "images/Kamel.svg"
        )
        val Noto = Project(
            name = "Noto",
            description = "Android notes application built using Kotlin. " +
                    "It features a minimalistic design, dark mode, reminders, organizing notes into libraries and more.",
            technologies = listOf(Kotlin, Android),
            githubLink = "https://github.com/alialbaali/Noto",
            link = "https://play.google.com/store/apps/details?id=com.noto",
            year = 2020U,
            imagePath = "images/Noto.svg"
        )
        val CastingAgency = Project(
            name = "Casting Agency",
            description = "An API that simulates a casting agency models a company that is " +
                    "responsible for creating movies and managing and assigning actors to those movies.",
            technologies = listOf(Python, Flask),
            githubLink = "https://github.com/alialbaali/FSND-Capstone",
            link = "https://casting-agency-udacity-capston.herokuapp.com/",
            year = 2020U,
        )
        val ChatyChaty = Project(
            name = "ChatyChaty",
            description = "Android chat application developed using Kotlin, " +
                    " and the backend implemented using C# by my friend Yousef.",
            technologies = listOf(Kotlin, Android),
            githubLink = "https://github.com/alialbaali/ChatyChaty",
            link = "http://chatychaty0.herokuapp.com/",
            year = 2020U,
        )
        val Shopally = Project(
            name = "Shopally",
            description = "An e-commerce API built entirely in Ktor, integrated with Stripe and Cloudinary services, and follows domain driven design structure and development.",
            technologies = listOf(Kotlin, Ktor),
            githubLink = "https://github.com/alialbaali/Shopping-API",
            link = "https://shopally.herokuapp.com/",
            year = 2020U,
        )
        val Website = Project(
            name = "Website",
            description = "My personal website built using Kotlin/JS by leveraging fritz2 framework in this version and HTML and CSS in the older one.",
            technologies = listOf(Kotlin, CSS, HTML),
            githubLink = "https://github.com/alialbaali/Website",
            year = 2021U,
        )
        val Minigrep = Project(
            name = "Minigrep",
            description = "Simple implementation of the grep tool that searches for words in a file by using command line arguments and environment variables.",
            technologies = listOf(Rust),
            githubLink = "https://github.com/alialbaali/Minigrep",
            year = 2021U,
        )

        val All = listOf(Kamel, Noto, ChatyChaty, Shopally, Website, CastingAgency, Minigrep)
    }
}
