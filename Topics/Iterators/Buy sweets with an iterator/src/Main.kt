fun countSum(sweets: Map<String, Int>): Int = sweets.values.sum()

fun main() {
    val cart = mutableMapOf<String, Int>()

    repeat(readln().toInt()) {
        readln().split(" ").let {
            cart[it[0]] = it[1].toInt()
        }
    }
    println(countSum(cart))
}