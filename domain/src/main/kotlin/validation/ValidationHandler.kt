package validation

import exceptions.DomainException
import kotlin.jvm.Throws

interface ValidationHandler {
    fun append(anError: Error): ValidationHandler
    fun append(anHandler: ValidationHandler): ValidationHandler
    fun validate(aValidation: Validation): ValidationHandler
    fun getErrors(): List<Error>
    fun hasErrors(): Boolean = getErrors().isNotEmpty()
    fun firstError(): Error? =  getErrors().firstOrNull()

    interface Validation{
        @Throws(Exception::class)
        fun validate()
    }
}