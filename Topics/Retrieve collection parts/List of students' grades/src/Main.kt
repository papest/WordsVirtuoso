const val NUMBER_OF_GRADES = 2

fun main() {
    val list = readln().split(" ")
    println(list.chunked(NUMBER_OF_GRADES))
}