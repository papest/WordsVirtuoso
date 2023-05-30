data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    val shipsListMap: List<Map<String, Int>> = shipsList.map { mapOf(it.name to it.ammunition) }
    val res = shipsListMap.map { mapOf(it.keys.first() to (it.values.first() + it.values.first())) }
    println(res)
}