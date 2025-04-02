package whitelabel.module

import extension.Extensions.Companion.isBase64
import validation.Error
import validation.ValidationHandler
import validation.Validator
import validation.handler.ThrowsValidationHandler
import whitelabel.enuns.LogoField

data class Base64 (val logo: String) {
    companion object {
        fun create(
            logo: String,
            fieldName: LogoField = LogoField.LOGO,
            handler: ValidationHandler = ThrowsValidationHandler()
        ) : Base64 {
            val validator = Base64Validator(handler, logo, fieldName)
            validator.validate()

            return Base64(logo)
        }
    }
}

class Base64Validator(
    private val handler: ValidationHandler,
    private val logo: String,
    private val logoField: LogoField = LogoField.LOGO,
) : Validator(handler) {
    override fun validate() {
        checkBlank()
        checkBase64()
    }

    private fun checkBlank() {
        when {
            logo.isBlank() -> handler.append(Error("Logo '${logoField.fieldName}' cannot be blank"))
            logo.isEmpty() -> handler.append(Error("Logo '${logoField.fieldName}' cannot be empty"))
        }
    }

    private fun checkBase64() {
        if(!logo.trim().isBase64()){
            handler.append(Error("Logo '${logoField.fieldName}' cannot be base64"))
        }
    }
}

