fun main() {
    val list = readln().split(" ")
    val res = list.runningFold(0) { acc, s -> acc + s.length }
    println(res)
}