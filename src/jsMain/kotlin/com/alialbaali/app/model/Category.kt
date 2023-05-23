package com.alialbaali.app.model

import com.alialbaali.app.model.Technology.*

enum class Category(val title: String, private vararg val technologies: Technology) {
    ProgrammingLanguages("Programming Languages", Kotlin, Rust, Java, Python),
    OtherLanguages("Other Languages", HTML, CSS, SQL),
    Frameworks("Frameworks", Android, Compose, Ktor, React, Flask),
    Platforms("Platforms", GitHub, Netlify, Docker, Supabase, Heroku),
    Tools("Tools", AndroidStudio, IntelliJ, Git, Postman, Linux),
    Design("Design", Figma, Inkscape);

    val content: List<Technology> = technologies.toList()
}