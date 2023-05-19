package com.alialbaali.app.components

import androidx.compose.runtime.Composable
import com.alialbaali.app.model.Section
import com.alialbaali.app.theme.style.ComponentsStyleSheet
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionName(section: Section) {
    Span(attrs = { classes(ComponentsStyleSheet.SectionName) }) {
        Text(section.name)
    }
}