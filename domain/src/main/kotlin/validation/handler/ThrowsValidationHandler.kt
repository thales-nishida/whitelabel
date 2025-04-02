package validation.handler

import exceptions.DomainException
import validation.Error
import validation.ValidationHandler

class ThrowsValidationHandler : ValidationHandler {
    override fun append(anError: Error): ValidationHandler {
        throw DomainException.with(anError)
    }

    override fun append(anHandler: ValidationHandler): ValidationHandler {
        if(anHandler.hasErrors()){
            throw DomainException.with(anHandler.getErrors())
        }
        return this
    }

    override fun validate(aValidation: ValidationHandler.Validation): ValidationHandler {
        try {
            aValidation.validate()
        } catch (e: Exception) {
            throw DomainException.with(Error(e.message ?: "Validation failed"))
        }
        return this
    }

    override fun getErrors(): List<Error> = emptyList()
}