@SuppressWarnings("MagicNumber")
fun main() {
    val list = readln().split(" ").map { it.toInt() }
    val res = list.none { i -> i < 3 || i % 3 != 0 }
    println(res)
}