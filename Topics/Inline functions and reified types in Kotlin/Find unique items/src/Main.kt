inline fun <reified T, reified R> uniqueSelectors(list: List<T>, selector: (T) -> R): List<R> =
    list.map(selector).distinct()