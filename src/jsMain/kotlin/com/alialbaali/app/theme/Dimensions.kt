package com.alialbaali.app.theme

import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh

object Dimensions {

    val ExtraTiny = 0.8.cssRem
    val Tiny = 1.6.cssRem
    val ExtraSmall = 2.4.cssRem
    val Small = 3.2.cssRem
    val Medium = 4.0.cssRem
    val Large = 4.8.cssRem
    val ExtraLarge = 5.6.cssRem
    val Huge = 6.4.cssRem
    val ExtraHuge = 7.2.cssRem

    val BorderRadius = ExtraTiny
    val MainPadding = Medium
    val FontScale = 62.5.percent
    val MainGap = 25.vh
    val TransitionDuration = 250.ms
    val TextDecorationThickness = 0.25.cssRem

}