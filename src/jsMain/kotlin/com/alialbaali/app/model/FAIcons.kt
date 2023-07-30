package com.alialbaali.app.model

object FAIcons {
    private const val Prefix = "fa"

    const val Menu = "$Prefix-bars"
    const val Close = "$Prefix-xmark"
    const val ExternalLink = "$Prefix-arrow-up-right-from-square"

    val Links.Profile.faIcon get() = "$Prefix-$name".lowercase()
}