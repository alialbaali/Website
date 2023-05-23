package com.alialbaali.app.model

enum class Technology(
    val title: String,
    val lightIconUrl: String,
    val darkIconUrl: String,
    val color: String = "",
) {
    Android(
        title = "Android",
        lightIconUrl = "logos/Android-Light.svg",
        darkIconUrl = "logos/Android-Dark.svg",
        color = "#69F0AE"
    ),
    Compose(
        title = "Compose",
        lightIconUrl = "logos/Compose-Light.svg",
        darkIconUrl = "logos/Compose-Dark.svg",
        color = "#64FFDA"
    ),
    Kotlin(
        title = "Kotlin",
        lightIconUrl = "https://skillicons.dev/icons?i=kotlin&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=kotlin&theme=dark",
        color = "#E040FB"
    ),
    Rust(
        title = "Rust",
        lightIconUrl = "https://skillicons.dev/icons?i=rust&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=rust&theme=dark",
        color = "#B2FF59"
    ),
    Python(
        title = "Python",
        lightIconUrl = "https://skillicons.dev/icons?i=python&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=python&theme=dark",
        color = "#536DFE"
    ),
    Figma(
        title = "Figma",
        lightIconUrl = "https://skillicons.dev/icons?i=figma&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=figma&theme=dark"
    ),
    Flask(
        title = "Flask",
        lightIconUrl = "https://skillicons.dev/icons?i=flask&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=flask&theme=dark",
        color = "#18FFFF"
    ),
    Git(
        title = "Git",
        lightIconUrl = "https://skillicons.dev/icons?i=git&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=git&theme=dark"
    ),
    CSS(
        title = "CSS",
        lightIconUrl = "https://skillicons.dev/icons?i=css&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=css&theme=dark",
        color = "#FFAB40"
    ),
    HTML(
        title = "HTML",
        lightIconUrl = "https://skillicons.dev/icons?i=html&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=html&theme=dark",
        color = "#EEFF41"
    ),
    Ktor(
        title = "Ktor",
        lightIconUrl = "https://skillicons.dev/icons?i=ktor&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=ktor&theme=dark",
        color = "#FF5252"
    ),
    Java(
        title = "Java",
        lightIconUrl = "https://skillicons.dev/icons?i=java&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=java&theme=dark"
    ),
    SQL(
        title = "SQL",
        lightIconUrl = "https://skillicons.dev/icons?i=postgresql&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=postgresql&theme=dark"
    ),
    Inkscape(
        title = "Inkscape",
        lightIconUrl = "logos/Inkscape-Light.svg",
        darkIconUrl = "logos/Inkscape-Dark.svg"
    ),
    React(
        title = "React",
        lightIconUrl = "https://skillicons.dev/icons?i=react&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=react&theme=dark"
    ),
    IntelliJ(
        title = "IntelliJ IDEA",
        lightIconUrl = "logos/IntelliJ-Light.svg",
        darkIconUrl = "logos/IntelliJ-Dark.svg"
    ),
    AndroidStudio(
        "Android Studio",
        "https://skillicons.dev/icons?i=androidstudio&theme=light",
        "https://skillicons.dev/icons?i=androidstudio&theme=dark",
    ),
    GitHub(
        title = "GitHub",
        lightIconUrl = "https://skillicons.dev/icons?i=github&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=github&theme=dark"
    ),
    Netlify(
        title = "Netlify",
        lightIconUrl = "https://skillicons.dev/icons?i=netlify&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=netlify&theme=dark"
    ),
    Docker(
        title = "Docker",
        lightIconUrl = "https://skillicons.dev/icons?i=docker&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=docker&theme=dark"
    ),
    Heroku(
        title = "Heroku",
        lightIconUrl = "https://skillicons.dev/icons?i=heroku&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=heroku&theme=dark"
    ),
    Postman(
        title = "Postman",
        lightIconUrl = "https://skillicons.dev/icons?i=postman&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=postman&theme=dark"
    ),
    Linux(
        title = "Linux",
        lightIconUrl = "https://skillicons.dev/icons?i=linux&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=linux&theme=dark"
    ),
    Supabase(
        title = "Supabase",
        lightIconUrl = "https://skillicons.dev/icons?i=supabase&theme=light",
        darkIconUrl = "https://skillicons.dev/icons?i=supabase&theme=dark"
    ),
}