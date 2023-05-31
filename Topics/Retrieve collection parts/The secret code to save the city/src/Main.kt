fun main() {
    val list = readln().split(" ")
    val res = list.windowed(2, 2, false) { i -> i.sumOf { it.length } }
    println(res)
}