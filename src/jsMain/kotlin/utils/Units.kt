package utils


inline val Number.px: String get() = toString().plus("px")
inline val Number.rem: String get() = toString().plus("rem")
inline val Number.per: String get() = toString().plus("%")
inline val Number.vh: String get() = toString().plus("vh")
inline val Number.vw: String get() = toString().plus("vw")