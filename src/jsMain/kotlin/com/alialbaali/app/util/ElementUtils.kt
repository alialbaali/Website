package com.alialbaali.app.util

import kotlinx.browser.window
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.dom.hasClass
import org.w3c.dom.Element
import org.w3c.dom.MutationObserver
import org.w3c.dom.MutationObserverInit

private const val AttributesType = "attributes"
private const val ClassAttributesName = "class"

val Element.isPartiallyVisible: Boolean
    get() {
        val rect = getBoundingClientRect()
        val halfViewport = window.innerHeight / 2
        val quarterViewPort = window.innerHeight / 4
        return rect.top <= halfViewport && rect.bottom >= quarterViewPort
    }

fun Element.hasClassAsFlow(className: String) = callbackFlow {
    trySend(this@hasClassAsFlow.hasClass(className))
    val observer = MutationObserver { records, _ ->
        records.forEach { record ->
            if (record.type == AttributesType && record.attributeName == ClassAttributesName) {
                val element = record.target as? Element
                val hasClass = element?.hasClass(className) ?: false
                trySend(hasClass)
            }
        }
    }
    observer.observe(this@hasClassAsFlow, MutationObserverInit(attributes = true))
    awaitClose { observer.disconnect() }
}