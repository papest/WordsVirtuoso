inline fun <reified T, reified R> convertList(list: List<T>, crossinline transform: (T) -> R): List<R> =
    list.map(transform)
