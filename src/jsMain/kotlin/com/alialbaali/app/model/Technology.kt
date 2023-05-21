package com.alialbaali.app.model

enum class Technology(val imagePath: String, val color: String = "") {
    Android("logos/Android.svg", "#69F0AE"),
    Compose("logos/Compose.svg", "#64FFDA"),
    Kotlin("logos/Kotlin.svg", "#E040FB"),
    Rust("logos/Rust.svg", "#B2FF59"),
    Python("logos/Python.svg", "#536DFE"),
    Figma("logos/Figma.svg"),
    Flask("logos/Flask.svg", "#18FFFF"),
    Git("logos/Git.svg"),
    CSS("logos/CSS.svg", "#FFAB40"),
    HTML("logos/HTML.svg", "#EEFF41"),
    Ktor("logos/Ktor.svg", "#FF5252"),
    Java("logos/Java.svg"),
    SQL("logos/SQL.svg"),
    Inkscape("logos/Inkscape.svg"),
    React("logos/React.svg"),
    Intellij(""),
    AndroidStudio(""),
    GitHub("logos/Git.svg"),
    Netlify("logos/Git.svg"),
    ComposeMultiplatform(""),
    Docker(""),
    Heroku(""),
    Postman(""),
    Linux("")
}