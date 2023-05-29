fun main() {
    val list = readln().split(" ")
    val res = list.filterIndexed { index, s -> index != 0 && s.length == 5 }
    println(res)
}