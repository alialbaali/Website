package com.alialbaali.app.components

import androidx.compose.runtime.Composable
import com.alialbaali.app.theme.AppStyleSheet
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

@Composable
fun HighlightedText(text: String, url: String) {
    A(
        href = url,
        attrs = {
            target(ATarget.Blank)
            classes(AppStyleSheet.HighlightedText)
        }
    ) {
        Text(text)
    }
}