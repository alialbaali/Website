package com.alialbaali.app.util

import com.alialbaali.app.theme.Theme

object StorageIds {
    const val Theme = "Theme"
}

fun String?.toThemeStatus(): Theme.Status? = when (this) {
    Theme.Status.Light.name -> Theme.Status.Light
    Theme.Status.Dark.name -> Theme.Status.Dark
    else -> null
}