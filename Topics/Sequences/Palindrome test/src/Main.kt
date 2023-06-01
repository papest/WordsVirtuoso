fun main() {
    val input = readln().split(" ").asSequence()
    println(input.count { it.reversed() == it })
}