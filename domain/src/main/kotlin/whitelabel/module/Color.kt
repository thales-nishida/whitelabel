package whitelabel.module

import validation.Error
import validation.ValidationHandler
import validation.Validator
import whitelabel.enuns.ColorField


data class Color(
    val hex: String,
) {
    companion object {
        fun create(
            hex: String,
            handler: ValidationHandler,
            field: ColorField = ColorField.COLOR,
        ): Color {
            val validator = ColorValidator(hex, handler, field)
            validator.validate()
            return Color(hex)
        }
    }

}

class ColorValidator(
    private val hex: String,
    private val handler: ValidationHandler,
    private val field: ColorField = ColorField.COLOR,
) : Validator(handler) {
    override fun validate() {
        checkHexFormat()
    }

    private fun checkHexFormat() {
        if (!hex.matches(HEX_COLOR_REGEX)) {
            handler.append(Error("'${field.fieldName}' must be a valid HEX format (#RRGGBB or #RGB)"))
        }
    }

    companion object {
        private val HEX_COLOR_REGEX = Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
    }
}
