fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    println(
        if (a > c) {
            a.coerceAtLeast(b)
        } else {
            c.coerceAtLeast(b)
        }
    )
}