fun main() {
    val list = readln().split(" ")
    val res = list.associateBy { it.length }
    println(res)
}