package com.alialbaali.app.model

object Strings {

    const val Version = "v3.1.3"
    const val Hello = "Hi there,"
    const val WhoAmI = "I'm Ali. I'm a Software Engineer and UI/UX Designer."
    const val WhatDoIDo = "I like to build cool things that live on the internet using modern tools and technologies."
    const val Contact = "Contact"
    const val ViewPortfolio = "View Portfolio"
    const val Username = "alialbaali"
    const val Submit = "Submit"
    const val Email = "Email"
    const val EmailPlaceholder = "example@company.com"
    const val Subject = "Subject"
    const val SubjectPlaceholder = "Give it a title!"
    const val Message = "Message"
    const val MessagePlaceholder = "What's on your mind?"
    const val Current = "Current"
    const val LearnMore = "Learn more"
    const val Ktor = "Ktor"
    const val PersonalWebsite = "personal website"
    const val UdacityNanodegreeProgram = "Udacity nanodegree program"
    const val Certificate = "certificate"
    const val RIP = "RIP"

    const val ContactInfoTitle = "I'm always looking for new opportunities."
    val ContactParagraph = listOf(
        "So, feel free to contact me at anytime, whether you have a question, request a feature, or just want to collaborate.",
        "Let's have some fun!"
    )

    val About = listOf(
        "I began my journey in 2018, when I started learning Java and Android development through online courses. After a while, I made my way to Kotlin and started exploring backend programming with",
        "Along the way, I picked up a few other technologies, such as SQL, Git, and Linux. During that time, I also managed to build my first",
        "using only HTML and Vanilla CSS.",
        "In 2020, I had the chance to take an",
        "which helped increase my backend programming knowledge, by developing applications using Python, Flask and other tools and have earned a",
        "Since then, I've been working on",
        "along with learning Rust, Compose, and Inkscape.",
    )

    object Noto {
        const val Title = "Noto"
        const val Subtitle = "Minimal Note-Taking Application"
        const val Description =
            "Noto provides an ad-free experience, private data handling, modern design, lightweight APK size, and quite amount of useful features, such as:"
        val Features = listOf(
            "Reading Mode.",
            "Undo/Redo functionality.",
            "Multi-selection for notes.",
            "Find in Note & Continuous search.",
            "Label filtering.",
            "And, much more!"
        )
    }

    object Kamel {
        const val Title = "Kamel"
        const val Subtitle = "Declarative Asynchronous Image Loading Library"
        val Description =
            """Multi-platform library which supports loading, caching, and displaying images in a Compose application.
                |
                |It provides an intuitive API which lets the developer configure fetchers, decoders, mappers, and other data specific for each target, if needed.
                |
                |By default, it utilizes Ktor client & an LRU caching algorithm under the hood to perform the requests. 
            """.trimMargin()
    }

    object Rainbow {
        const val Title = "Rainbow for Reddit"
        const val Subtitle = "Unique Desktop Client for Browsing Reddit"
        const val Description =
            "Rainbow is a multi-platform application that enables users to browse Reddit smoothly on desktop. It establishes many valuable features, such as:"
        const val Note =
            "Due to the recent Reddit API changes, the app has been abandoned, and is only used for display purposes."
        val Features = listOf(
            "Ad-Free experience.",
            "Beautiful & polished UI.",
            "Detailed view for subreddits & users.",
            "Lazy loading & paging support.",
            "Browser-like navigation system.",
            "Ability to search subreddits, users, and posts.",
        )
    }

    object ChatyChaty {
        const val Title = "ChatyChaty"
        const val Subtitle = "Basic Messaging Application"
        val Description =
            """ChatyChaty delivers a simple, elegant UI to find users, and start chatting with them. It also provides a few client-side convenient features to enhance the experience.
                |
                |Furthermore, it communicates in real time through WebSockets API using Retrofit & Kotlin Flows. The project is based on MVVM design pattern, and Clean Architecture.
                |
                |The API is developed using .Net Framework with SignalR & C# by my friend Yousif.
            """.trimMargin()
    }

    object CastingAgency {
        const val Title = "Casting Agency"
        const val Subtitle = "Simulated Movies & Actors Management API"
        val Description =
            """API that models a company which is responsible for creating movies, and managing and assigning actors to those movies.
                |
                |It provides endpoints to perform CRUD operations on the data, along with adequate error handling.
            """.trimMargin()
    }

    object Shopally {
        const val Title = "Shopally"
        const val Subtitle = "Dummy E-Commerce API"
        val Description =
            """Shopally implements a way for users to sign up to the site, browse the products, add them to the cart, and order them.
                | 
                |The project follows Domain Driven Design structure and RESTful architecture style with more than 30 endpoints implemented by making use of:
            """.trimMargin()
        val Features = listOf(
            "JWT for authentication.",
            "SQLDelight for database management.",
            "Cloudinary for product info & images.",
            "Stripe for payment methods.",
        )
    }

    object Website {
        const val Title = "Website"
        const val Subtitle = "Futuristic Site"
        val Description =
            """This website is built using Kotlin/JS & Compose HTML. It supports accessibility, dark mode, and other features.
                |
                |It also utilizes CSS concepts, such as, media queries, flexbox, and animations.
            """.trimMargin()
    }

    object Minigrep {
        const val Title = "Minigrep"
        const val Subtitle = "Simple CLI Tool"
        const val Description =
            "Simple implementation of the grep tool that searches for words in a file by using command line arguments and environment variables."
    }

}