package com.alialbaali.app.util

import kotlinx.browser.window
import org.w3c.dom.Element

val Element.isPartiallyVisible: Boolean
    get() {
        val rect = getBoundingClientRect()
        val halfViewport = window.innerHeight / 2
        val quarterViewPort = window.innerHeight / 4
        return rect.top <= halfViewport && rect.bottom >= quarterViewPort
    }