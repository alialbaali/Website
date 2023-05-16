package com.alialbaali.app.util

import org.jetbrains.compose.web.css.StyleScope

fun StyleScope.userSelect(value: String) {
    property("user-select", value)
}