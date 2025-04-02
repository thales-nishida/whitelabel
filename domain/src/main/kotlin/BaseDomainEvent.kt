import java.time.Instant
import java.util.*

data class BaseDomainEvent(
    override val eventId: UUID = UUID.randomUUID(),
    override val aggregateId: String,
    override val eventType: String,
    override val occurredOn: Instant = Instant.now(),
    override val version: Int = 1,
    override val metadata: Map<String, Any> = emptyMap()
) : DomainEvent