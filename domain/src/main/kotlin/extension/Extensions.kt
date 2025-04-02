package extension

import validation.Error
import java.util.*

class Extensions {
    companion object {
        fun List<Error>.joinToMessage(): String {
            return joinToString(prefix = "[", postfix = "]", separator = ", ") { it.message }
        }

        fun String.isBase64(): Boolean {
            val cleanedInput = this.replace("\n", "").replace(" ", "")

            val base64Pattern = Regex(
                "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$"
            )
            if (!base64Pattern.matches(this)) return false

            return try {
                Base64.getDecoder().decode(cleanedInput)
                true
            } catch (e: IllegalArgumentException) {
                false
            }
        }
    }
}