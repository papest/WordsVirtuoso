fun main() {
    val list = readln().split(" ")
    val res = list.associate { it.first().uppercase() to it.length }
    println(res)
}