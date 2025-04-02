package whitelabel

import Identifier
import java.util.*

class WhiteLabelID constructor(private val value: String) : Identifier() {
    companion object {
        fun unique(): WhiteLabelID {
            return WhiteLabelID(UUID.randomUUID().toString())
        }

        fun from(anId: String): WhiteLabelID {
            require(anId.isNotEmpty()) { "WhitelabelID can't be empty" }
            return WhiteLabelID(anId)
        }

        fun from(anId: WhiteLabelID): WhiteLabelID {
            return WhiteLabelID(anId.toString().lowercase(Locale.getDefault()))
        }

    }
}