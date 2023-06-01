const val LOWER_LIMIT_LENGHT = 5
const val LIMIT = 3
fun main() {
    val list = readln().split(" ").asSequence()
    println(
        list
            .filter { it.length > LOWER_LIMIT_LENGHT }
            .take(LIMIT)
            .map { it.reversed().uppercase() }
            .toList()
    )
}