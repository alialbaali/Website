package com.alialbaali.app.model

import com.alialbaali.app.model.Technology.*
import kotlin.js.Date

data class Project(
    val name: String,
    val subtitle: String,
    val description: String,
    val technologies: List<Technology>,
    val year: UInt,
    val link: String? = null,
    val githubLink: String,
    val imagePath: String? = null,
    val features: List<String> = emptyList(),
) {

    val isHighlighted get() = imagePath != null

    companion object {

        val Noto = Project(
            name = "Noto",
            subtitle = "Minimal Note-Taking Application",
            description = "Noto provides ad-free experience, private data handling, modern design, lightweight APK size, and quite amount of useful features, such as:",
            technologies = listOf(Kotlin, SQL, Android, Compose, Supabase, Figma),
            githubLink = "https://github.com/alialbaali/Noto",
            link = "https://play.google.com/store/apps/details?id=com.noto",
            year = Date().getFullYear().toUInt(),
            imagePath = "images/Noto.svg",
            features = listOf(
                "Reading Mode.",
                "Undo/Redo functionality.",
                "Multi-selection for notes.",
                "Find in Note & Continuous search.",
                "Label filtering.",
                "And, much more!"
            )
        )

        val Kamel = Project(
            name = "Kamel",
            subtitle = "Declarative Asynchronous Image Loading Library",
            description = """Multi-platform library which supports loading, caching, and displaying images in a Compose application.
                |
                |It provides an intuitive API which let's the developer configure fetchers, decoders, mappers, and other data specific for each target, if needed.
                |
                |By default, it utilizes Ktor client & an LRU caching algorithm under the hood to perform the requests. 
            """.trimMargin(),
            technologies = listOf(Kotlin, Compose, Ktor, Maven),
            githubLink = "https://github.com/alialbaali/Kamel",
            year = Date().getFullYear().toUInt(),
            imagePath = "images/Kamel.svg"
        )

        val CastingAgency = Project(
            name = "Casting Agency",
            subtitle = "Simulated Movies & Actors Management API",
            description = """API that models a company which is responsible for creating movies, and managing and assigning actors to those movies.
                |
                |It provides endpoints to perform CRUD operations on the data, along with adequate error handling.
            """.trimMargin(),
            technologies = listOf(Python, SQL, Flask, Docker),
            githubLink = "https://github.com/alialbaali/FSND-Capstone",
            year = 2020U,
        )

        val ChatyChaty = Project(
            name = "ChatyChaty",
            subtitle = "Basic Messaging Application",
            description = """ChatyChaty delivers a simple, elegant UI to find users, and start chatting with them. It also provides a few client-side convenient features to enhance the experience.
                |
                |Furthermore, it communicates in real time through WebSockets API using Retrofit & Kotlin Flows. The project is based on MVVM design pattern, and Clean Architecture.
                |
                |The API is developed using .Net Framework with SignalR & C# by my friend Yousif.
            """.trimMargin(),
            technologies = listOf(Kotlin, SQL, Android, Figma),
            githubLink = "https://github.com/alialbaali/ChatyChaty",
            year = 2020U,
        )

        val Shopally = Project(
            name = "Shopally",
            subtitle = "Dummy E-Commerce API",
            description = """Shopally implements a way for users to sign up to the site, browse the products, add them to the cart, and order them.
                | 
                |The project follows Domain Driven Design structure and RESTful architecture style with more than 30 endpoints implemented by making use of:
            """.trimMargin(),
            technologies = listOf(Kotlin, SQL, Ktor, Docker, Heroku),
            githubLink = "https://github.com/alialbaali/Shopping-API",
            year = 2020U,
            features = listOf(
                "JWT for authentication.",
                "SQLDelight for database management.",
                "Cloudinary for product info & images.",
                "Stripe for payment methods.",
            )
        )

        val Website = Project(
            name = "Website",
            subtitle = "Futuristic Site",
            description = """This website is built using Kotlin/JS & Compose HTML. It supports accessibility, dark mode, and other features.
                |
                |It also utilizes CSS concepts, such as, media queries, flexbox, and animations.""".trimMargin(),
            technologies = listOf(Kotlin, HTML, CSS, Netlify, Figma),
            githubLink = "https://github.com/alialbaali/Website",
            year = Date().getFullYear().toUInt(),
        )

        val Minigrep = Project(
            name = "Minigrep",
            subtitle = "Simple CLI Tool",
            description = "Simple implementation of the grep tool that searches for words in a file by using command line arguments and environment variables.",
            technologies = listOf(Rust, Linux),
            githubLink = "https://github.com/alialbaali/Minigrep",
            year = 2021U,
        )

        val All = listOf(Noto, Kamel, ChatyChaty, Shopally, Website, CastingAgency, Minigrep)
    }
}
