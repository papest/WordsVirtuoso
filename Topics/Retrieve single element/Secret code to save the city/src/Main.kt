fun main() {
    val list = readln().split(" ")
    val res = list
        .firstOrNull { it.last() == 'm' }?.reversed()
    println(res)
}