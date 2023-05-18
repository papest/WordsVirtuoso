fun main() {
    val list = readln().split(" ")
    val res = list.any { i -> i.matches("abracadabra".toRegex(RegexOption.IGNORE_CASE)) }
    println(res)
}