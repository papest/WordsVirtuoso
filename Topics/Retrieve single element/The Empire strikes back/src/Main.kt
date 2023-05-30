data class Ship(val name: String, val ammunition: Int)

const val LOW_LIMIT = 200

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    println(shipsList.findLast { it.ammunition > LOW_LIMIT }?.name ?: "No ship found")
}