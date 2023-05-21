data class Spell(val name: String, val power: Int)
@Suppress("MagicNumber")
fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }
    val res = spells.fold(0) { acc, it -> if (it.power > 39) acc + it.power else acc }
    println(res)
}