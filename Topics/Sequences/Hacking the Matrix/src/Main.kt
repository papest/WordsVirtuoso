fun main() {
    val sequence = readln().split(" ").map { it.toInt() }.asSequence()
    println(
        sequence
            .filter { it % 2 != 0 }
            .map { it + it }
            .chunked(2) { it.sum() }
            .toList()
    )
}