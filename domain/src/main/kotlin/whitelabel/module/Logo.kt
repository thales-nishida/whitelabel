package whitelabel.module

import validation.Error
import validation.ValidationHandler
import validation.Validator
import validation.handler.ThrowsValidationHandler
import whitelabel.enuns.LogoField

data class Logo (val logo: String) {
    companion object {
        fun create(
            logo: String,
            fieldName: LogoField = LogoField.LOGO,
            handler: ValidationHandler = ThrowsValidationHandler()
        ) : Logo {
            val validator = LogoValidator(handler, logo, fieldName)
            validator.validate()

            return Logo(logo)
        }
    }
}

class LogoValidator(
    private val handler: ValidationHandler,
    private val logo: String,
    private val logoField: LogoField = LogoField.LOGO,
) : Validator(handler) {
    override fun validate() {
        checkBlank()
    }

    private fun checkBlank() {
        when {
            logo.isBlank() -> handler.append(Error("Logo '${logoField.fieldName}' cannot be blank"))
            logo.isEmpty() -> handler.append(Error("Logo '${logoField.fieldName}' cannot be empty"))
        }
    }
}

