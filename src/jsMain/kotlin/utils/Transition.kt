package utils

import dev.fritz2.styling.params.BasicParams

fun BasicParams.transition(
    property: () -> String = { "all" },
    duration: () -> Double = { 0.5 },
    function: () -> String = { "cubic-bezier(0, 0, 0, 1)" },
    delay: () -> Double = { 0.0 }
) {
    css(" transition: ${property()} ${duration()}s ${function()} ${delay()}s;")
}