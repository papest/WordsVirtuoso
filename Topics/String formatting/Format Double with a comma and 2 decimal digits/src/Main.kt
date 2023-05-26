import java.util.*

fun main() {
    val value = readln().toDouble()
    val doubleString = String.format(Locale.ENGLISH, "%,.2f", value)
    println(doubleString)
}