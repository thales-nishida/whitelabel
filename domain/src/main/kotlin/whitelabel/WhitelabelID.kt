package whitelabel

import Identifier
import java.util.*

class WhitelabelID constructor(private val value: String) : Identifier() {
    companion object {
        fun unique(): WhitelabelID {
            return WhitelabelID(UUID.randomUUID().toString())
        }

        fun from(anId: String): WhitelabelID {
            require(anId.isNotEmpty()) { "WhitelabelID can't be empty" }
            return WhitelabelID(anId)
        }

        fun from(anId: WhitelabelID): WhitelabelID {
            return WhitelabelID(anId.toString().lowercase(Locale.getDefault()))
        }

    }
}