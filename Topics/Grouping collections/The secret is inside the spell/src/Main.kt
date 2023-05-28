fun main() {
    val list = readln().split(" ")
    val res = list.groupBy(keySelector = String::first, valueTransform = String::length)
        .mapValues { it.value.sum() }
    println(res)
}