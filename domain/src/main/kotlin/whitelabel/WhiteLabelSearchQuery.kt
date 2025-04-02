package whitelabel

data class WhiteLabelSearchQuery(
    val page: Int,
    val perPage: Int,
    val terms: String,
    val sort: String,
    val direction: String
)
