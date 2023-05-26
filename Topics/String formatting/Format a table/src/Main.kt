import java.util.*

fun main() {
    val a = readln().toDouble()
    val b = readln().toDouble()
    val c = readln().toDouble()
    val d = readln().toDouble()

    println(String.format(Locale.ENGLISH, "%,12.2f%,12.2f\n%,12.2f%,12.2f", a, b, c, d))
}