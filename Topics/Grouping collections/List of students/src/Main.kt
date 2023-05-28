fun main() {
    val list = readln().split(" ")
    val res = list.groupBy { it.first() }.mapValues { i -> i.value.maxByOrNull { it.length } }
    println(res)
}