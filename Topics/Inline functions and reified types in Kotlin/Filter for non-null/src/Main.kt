inline fun <T> filterNonNullValues(list: List<Any?>): List<T> =
    list.filterNotNull().map { it as T }