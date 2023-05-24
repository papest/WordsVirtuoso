fun main() {
    val list = readln().split(" ")
    val res = list.sumOf { it.length }
    println(res)
}