package com.alialbaali.app.section

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alialbaali.app.theme.style.FooterStyleSheet
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Text
import kotlin.js.Date

@Composable
fun Footer() {
    val currentYear = remember { Date().getFullYear() }
    Footer(attrs = { classes(FooterStyleSheet.Text) }) {
        Text("$currentYear © Ali Albaali — One step at a time")
    }
}