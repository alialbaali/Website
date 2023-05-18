package com.alialbaali.app.util

import com.alialbaali.app.model.Section
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.NavStyleSheet
import org.w3c.dom.*

fun Window.scrollToSection(section: Section) {
    val navbarElementHeight = document.getElementsByClassName(NavStyleSheet.Header)[0]?.clientHeight ?: 0
    val sectionElement = document.getElementsByClassName(AppStyleSheet.SectionName)[section.ordinal]
    val sectionElementRelativePosition = sectionElement?.getBoundingClientRect()?.top ?: 0.0
    val sectionElementActualPosition = pageYOffset + sectionElementRelativePosition - navbarElementHeight
    val scrollOptions = ScrollToOptions(top = sectionElementActualPosition, behavior = ScrollBehavior.SMOOTH)
    window.scrollTo(scrollOptions)
}

fun Window.scrollToTop() {
    scroll(
        ScrollToOptions(
            top = 0.0,
            behavior = ScrollBehavior.SMOOTH
        )
    )
}