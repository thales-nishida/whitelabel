package pagination

data class Pagination<T>(
    val currentPage: Int,
    val perPage: Int,
    val totalPages: Int,
    val items: List<T>,
)
