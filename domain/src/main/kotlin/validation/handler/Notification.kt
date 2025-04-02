package validation.handler

import exceptions.DomainException
import validation.Error
import validation.ValidationHandler

class Notification private constructor(private val errors: MutableList<Error> = mutableListOf()) : ValidationHandler {
    companion object {
        fun create(): Notification = Notification()
        fun fromThrowable(t: Throwable): Notification {
            val message = when (t) {
                is DomainException -> t.getErrors().joinToString { it.message }
                else -> t.message ?: "Unknown error"
            }
            return create().append(Error(message))
        }
    }


    override fun append(anError: Error): Notification {
        errors.add(anError)
        return this
    }

    override fun append(anHandler: ValidationHandler): Notification {
        errors.addAll(anHandler.getErrors())
        return this
    }

    override fun validate(aValidation: ValidationHandler.Validation): Notification {
        try {
            aValidation.validate()
        } catch (t: Throwable) {
            append(Error(t.message ?: "Validation failed"))
        }
        return this
    }

    override fun getErrors(): List<Error> = errors.toList()

}