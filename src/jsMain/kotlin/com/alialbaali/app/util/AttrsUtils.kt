package com.alialbaali.app.util

import org.jetbrains.compose.web.attributes.AttrsScope

fun AttrsScope<*>.feather(icon: String) = attr("data-feather", icon)