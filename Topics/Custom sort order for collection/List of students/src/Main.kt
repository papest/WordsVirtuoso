fun main() {
    val list = readln().split(" ")
    val res = list.sortedBy { it.lowercase() }
    println(res)
}