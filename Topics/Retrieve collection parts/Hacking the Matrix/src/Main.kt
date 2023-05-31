fun main() {
    val list = readln().split(" ").map { it.toInt() }
    val res = list.dropLastWhile { it % 2 == 0 }
    println(res)
}