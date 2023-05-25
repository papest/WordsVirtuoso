inline fun <reified T> filterByType(list: List<Any>): List<T> = list.filterIsInstance<T>()
