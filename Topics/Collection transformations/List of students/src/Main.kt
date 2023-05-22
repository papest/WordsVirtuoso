fun main() {
    val list = readln().split(" ")
    println(list.joinToString(", ", "", "", 2, "*") { "$it->${it.length}" })
}