package exceptions

import extension.Extensions.Companion.joinToMessage
import validation.Error
import validation.handler.Notification

class DomainException private constructor(
    private val anErrors: List<Error>,
    cause: Throwable? = null,
) : NoStacktraceException(anErrors.joinToMessage(), cause) {
    companion object {
        fun with(error: Error) : DomainException = DomainException(listOf(error))
        fun with(errors: List<Error>) : DomainException = DomainException(errors)
        fun with(notification: Notification) : DomainException = DomainException(notification.getErrors())
    }

    fun getErrors(): List<Error> = anErrors
}