data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    val res = shipsList.groupBy(keySelector = Ship::name, valueTransform = Ship::ammunition)
        .mapValues { it.value.sum() }
    println(res)
}