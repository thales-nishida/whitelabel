import java.time.Instant
import java.util.UUID

interface DomainEvent {
    val eventId: UUID
    val aggregateId: String
    val eventType: String
    val occurredOn: Instant
    val version: Int
    val metadata: Map<String, Any>
}