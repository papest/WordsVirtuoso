fun intDivision(x: String, y: String): Int {
    try {
        return x.toInt() / y.toInt()
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
    } catch (e: Exception) {
        if (y.toInt() == 0) {
            println("Exception: division by zero!")
        }
    }
    return 0
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}