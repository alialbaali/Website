package com.alialbaali.app.util

import kotlinx.browser.window
import org.w3c.dom.Element

val Element.isVisible: Boolean
    get() {
        val rect = getBoundingClientRect()
        return rect.top < window.innerHeight && rect.bottom >= 0
    }