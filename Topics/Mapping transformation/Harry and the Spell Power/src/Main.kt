data class Spell(val name: String, val power: Int)

const val MIN_POWER = 40
fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }
    val res = spells.filter { it.power >= MIN_POWER }.map { it.name }
    println(res)
}