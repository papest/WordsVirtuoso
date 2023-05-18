@SuppressWarnings("MagicNumber")
fun main() {
    val list = readln().split(" ").map { it.toInt() }
    val res = list.all { i -> i < 21 && i % 2 == 0 }
    println(res)
}