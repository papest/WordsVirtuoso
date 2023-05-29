fun main() {
    val list = readln().split(" ")
    val res = list.sortedBy { it.length }.reversed()
    println(res)
}