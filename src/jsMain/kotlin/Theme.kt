import dev.fritz2.styling.theme.*
import utils.rem

object WebsiteTheme : DefaultTheme() {

    override val fontSizes: ScaledValue =
        ScaledValue(
            smaller = 0.75.rem,
            small = 1.rem,
            normal = 1.25.rem,
            large = 1.5.rem,
            larger = 2.rem,
            huge = 3.rem,
            giant = 4.rem,
            full = 5.rem,
        )

    override val fontFamilies = object : FontFamilies {
        override val normal =
            "Inter, Roboto, Helvetica, Calibri, Arial, 'DejaVu Sans', 'Apple Color Emoji', 'Segoe UI Emoji', -apple-system, sans-serif"
        override val mono =
            "Courier, Consolas, 'Liberation Mono', Menlo, 'Courier New', SFMono-Regular, monospace"
    }

    override val colors: Colors
        get() = object : Colors {
            override val gray50 = "#F7FAFC"
            override val gray100 = "#EDF2F7"
            override val gray200 = "#E2E8F0"
            override val gray300 = "#CBD5E0"
            override val gray400 = "#A0AEC0"
            override val gray500 = "#718096"
            override val gray600 = "#4A5568"
            override val gray700 = "#2D3748"
            override val gray800 = "#1A202C"
            override val gray900 = "#171923"
//
//            override val neutral =
//                ColorScheme(
//                    main = "#EDF6F9",
//                    mainContrast = "#000000",
//                    highlight = "#000000",
//                    highlightContrast = "#EDF6F9"
//                )

            override val neutral =
                ColorScheme(
                    main = "#000000",
                    mainContrast = "#EDF6F9",
                    highlight = "#EDF6F9",
                    highlightContrast = "#000000"
                )

            override val primary =
                ColorScheme(
                    main = "#006D77",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = "#006D77"
                )

            override val secondary =
                ColorScheme(
                    main = "#E29578",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = "#E29578"
                )

            override val tertiary =
                ColorScheme(
                    main = "#83C5BE",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = "#83C5BE"
                )

            // Signal Colors
            override val info =
                ColorScheme(
                    main = "#FFDDD2",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = "#FFDDD2"
                )

            override val success =
                ColorScheme(
                    main = "#00A848",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = gray700
                )

            override val warning =
                ColorScheme(
                    main = "#F08B3A",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = gray700
                )

            override val danger =
                ColorScheme(
                    main = "#E14F2A",
                    mainContrast = neutral.mainContrast,
                    highlight = neutral.highlight,
                    highlightContrast = gray700
                )

            //FIXME: move to typography section
            override val font = neutral.mainContrast
            override val background = neutral.main
            override val disabled = gray300
            override val focus = primary.highlight
        }

}

val Colors.surface
    get() = primary.main.plus("50")