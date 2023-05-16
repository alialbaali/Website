package com.alialbaali.app.util

import com.alialbaali.app.model.Section
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions
import org.w3c.dom.Window


fun Window.scrollToSection(section: Section) {
    when (section) {
        Section.About -> scroll(
            ScrollToOptions(
                top = 750.0,
                behavior = ScrollBehavior.SMOOTH
            )
        )

        Section.Skills -> scroll(
            ScrollToOptions(
                top = 1750.0,
                behavior = ScrollBehavior.SMOOTH
            )
        )

        Section.Portfolio -> scroll(
            ScrollToOptions(
                top = 2780.0,
                behavior = ScrollBehavior.SMOOTH
            )
        )
    }
}

fun Window.scrollToTop() {
    scroll(
        ScrollToOptions(
            top = 0.0,
            behavior = ScrollBehavior.SMOOTH
        )
    )
}