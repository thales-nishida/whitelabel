package extension

import validation.Error

class Extensions {
    companion object {
        fun List<Error>.joinToMessage(): String {
            return joinToString(prefix = "[", postfix = "]", separator = ", ") { it.message }
        }
    }
}