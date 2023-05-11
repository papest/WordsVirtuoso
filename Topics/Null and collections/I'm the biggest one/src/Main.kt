fun main() {
    readln().split(" ").mapNotNull { it.toIntOrNull() }
        .run { println(maxOrNull()) }
}