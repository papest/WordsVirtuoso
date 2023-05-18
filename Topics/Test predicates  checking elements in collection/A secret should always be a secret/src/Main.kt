fun main() {
    val list = readln().split(" ")
    val res = list.none { i -> i.lowercase() == "secret" }
    println(res)
}