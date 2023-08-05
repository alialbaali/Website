package com.alialbaali.app.model

object Links {
    const val Mail = "mailto:ali@albaali.com"
    const val Ktor = "https://ktor.io/"
    const val WebsiteV1 = "https://v1.alialbaali.com"
    const val UdacityNanodegreeProgram = "https://www.udacity.com/course/full-stack-web-developer-nanodegree--nd0044"
    const val Certificate = "https://graduation.udacity.com/confirm/N72UE3J"
    const val Noto = "https://play.google.com/store/apps/details?id=com.noto"

    object GitHub {
        const val Noto = "https://github.com/alialbaali/Noto"
        const val Kamel = "https://github.com/Kamel-Media/Kamel"
        const val ChatyChaty = "https://github.com/alialbaali/ChatyChaty"
        const val CastingAgency = "https://github.com/alialbaali/FSND-Capstone"
        const val Shopally = "https://github.com/alialbaali/Shopally"
        const val Website = "https://github.com/alialbaali/Website"
        const val Minigrep = "https://github.com/alialbaali/Minigrep"
    }

    enum class Profile(val url: String, val iconName: String? = null) {
        Twitter("https://twitter.com/ali_albaali/"),
        X("https://x.com/ali_albaali/", "x-twitter"),
        Instagram("https://instagram.com/ali.albaali"),
        Dribbble("https://dribbble.com/alialbaali/"),
        LinkedIn("https://www.linkedin.com/in/alialbaali/"),
        GitHub("https://github.com/alialbaali/"),
        Mastodon("https://mastodon.social/@alialbaali"),
    }
}