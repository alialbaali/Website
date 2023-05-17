package com.alialbaali.app.util

import com.alialbaali.app.model.Section
import com.alialbaali.app.theme.AppStyleSheet
import com.alialbaali.app.theme.Dimensions
import org.w3c.dom.*

fun Window.scrollToSection(section: Section) {
    val documentHeight = document.documentElement?.clientHeight ?: 0
    val sectionGapInPixels = (documentHeight * Dimensions.MainGap.value) / 100
    val sectionElement = document.getElementsByClassName(AppStyleSheet.SectionName)[section.ordinal]
    val sectionElementRelativePosition = sectionElement?.getBoundingClientRect()?.top ?: 0.0
    val sectionElementActualPosition = pageYOffset + sectionElementRelativePosition - sectionGapInPixels
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