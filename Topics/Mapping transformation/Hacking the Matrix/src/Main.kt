fun main() {
    val list = readln().split(" ")
    val res = list
        .mapIndexed { index, s -> if (index % 2 == 0) s.length else 0 }
        .sum()
    println(res)
}