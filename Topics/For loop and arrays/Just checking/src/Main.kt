fun main() {
    val size = readln().toInt()
    val list1 = List(size) { readln() }
    val list2 = readln().split(" ")
    println(if (list1.containsAll(list2)) "YES" else "NO")
}