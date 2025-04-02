package whitelabel

import pagination.Pagination
import java.util.*

interface WhitelabelGateWay {
    fun create(whitelabel: Whitelabel): Whitelabel
    fun update(anWhitelabel: Whitelabel): Whitelabel
    fun findById(anId: WhitelabelID): Optional<Whitelabel>
    fun deleteById(anID: WhitelabelID)
    fun findAll(query: WhiteLabelSearchQuery) : Pagination<Whitelabel>
}