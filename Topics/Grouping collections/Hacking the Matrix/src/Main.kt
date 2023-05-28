fun main() {
    val list = readln().split(" ")
    val res = list.groupingBy { it.length }.eachCount()
    println(res)
}