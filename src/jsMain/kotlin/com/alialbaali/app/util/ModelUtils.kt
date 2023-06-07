package com.alialbaali.app.util

import com.alialbaali.app.model.Project
import com.alialbaali.app.model.Strings
import com.alialbaali.app.model.Technology
import org.jetbrains.compose.web.css.Color
import kotlin.js.Date

val Technology.lightCSSColor
    get() = Color("#$lightColor")

val Technology.darkCSSColor
    get() = Color("#$darkColor")

val Project.isCurrent: Boolean
    get() {
        val currentYear = Date().getFullYear().toUInt()
        return year == currentYear
    }

val Project.yearAsString
    get() = if (isCurrent) Strings.Current else year.toString()

val Project.imageBackgroundCssColor
    get() = Color("#$imageBackgroundColor")