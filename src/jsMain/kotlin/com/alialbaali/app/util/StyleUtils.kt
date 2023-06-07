package com.alialbaali.app.util

import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.StyleSheet
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun StyleScope.userSelect(value: String) {
    property("user-select", value)
}

class CSSClass(private val usePrefix: Boolean) {
    operator fun provideDelegate(
        sheet: StyleSheet,
        property: KProperty<*>
    ): ReadOnlyProperty<Any?, String> {
        val sheetName = if (usePrefix) "${sheet::class.simpleName}-" else ""
        val className = "$sheetName${property.name}"
        return ReadOnlyProperty { _, _ -> className }
    }
}

fun StyleSheet.cssClass() = CSSClass(usePrefix)