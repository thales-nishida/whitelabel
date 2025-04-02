import validation.ValidationHandler

abstract class Entity<ID: Identifier>(open val id: ID) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Entity<*>
        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    abstract fun validate(handler: ValidationHandler)
}