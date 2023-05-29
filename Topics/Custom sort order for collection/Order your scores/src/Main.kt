fun main() {
    val list = readln().split(" ").map { it.toInt() }
    val res = list.sortedByDescending { it % 2 }
    println(res)
}