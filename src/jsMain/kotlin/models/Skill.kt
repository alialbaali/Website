package models

value class Skill(val value: String) {

    val name: String
        get() = value.removePrefix("Logos/")
            .removeSuffix(".svg")

    companion object {
        val Android = Skill("Logos/Android.svg")
        val Compose = Skill("Logos/Compose.svg")
        val Rust = Skill("Logos/Rust.svg")
        val Kotlin = Skill("Logos/Kotlin.svg")
        val Python = Skill("Logos/Python.svg")
        val Figma = Skill("Logos/Figma.svg")
        val Flask = Skill("Logos/Flask.svg")
        val Git = Skill("Logos/Git.svg")
        val CSS = Skill("Logos/CSS.svg")
        val HTML = Skill("Logos/HTML.svg")
        val Ktor = Skill("Logos/Ktor.svg")
        val Java = Skill("Logos/Java.svg")
        val SQL = Skill("Logos/SQL.svg")
        val Inkscape = Skill("Logos/Inkscape.svg")
        val React = Skill("Logos/React.svg")

        val All = listOf(
            Android,
            Compose,
            Rust,
            Kotlin,
            Python,
            Figma,
            Flask,
            Git,
            CSS,
            HTML,
            Ktor,
            Java,
            SQL,
            Inkscape,
            React
        )
    }

}