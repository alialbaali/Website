package com.alialbaali.app.model

object Links {
    const val Mail = "mailto:ali@albaali.com"
    const val Ktor = "https://ktor.io/"
    const val WebsiteV1 = "https://v1.alialbaali.com"
    const val UdacityNanodegreeProgram = "https://www.udacity.com/course/full-stack-web-developer-nanodegree--nd0044"
    const val Certificate = "https://graduation.udacity.com/confirm/N72UE3J"
    const val Noto = "https://play.google.com/store/apps/details?id=com.noto"
}

object GitHubLinks {
    const val Noto = "https://github.com/alialbaali/Noto"
    const val Kamel = "https://github.com/Kamel-Media/Kamel"
    const val ChatyChaty = "https://github.com/alialbaali/ChatyChaty"
    const val CastingAgency = "https://github.com/alialbaali/FSND-Capstone"
    const val Shopally = "https://github.com/alialbaali/Shopally"
    const val Website = "https://github.com/alialbaali/Website"
    const val Minigrep = "https://github.com/alialbaali/Minigrep"
}

enum class ProfileLinks(val iconName: String, val url: String) {
    Twitter("twitter", "https://twitter.com/ali_albaali/"),
    Instagram("instagram", "https://instagram.com/ali.albaali"),
    Dribbble("dribbble", "https://dribbble.com/alialbaali/"),
    LinkedIn("linkedin", "https://www.linkedin.com/in/alialbaali/"),
    GitHub("github", "https://github.com/alialbaali/");

    companion object {
        val All = values().toList()
    }
}