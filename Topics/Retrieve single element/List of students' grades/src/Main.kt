const val SOME_NUMBER = 5
fun main() {
    val list = readln().split(" ").map { it.toDouble() }
    println("${list.firstOrNull { it >= SOME_NUMBER }}:${list.lastOrNull()}")
}