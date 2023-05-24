data class Ship(val name: String, val ammunition: Int)
class ShipComparator : Comparator<Ship> {
    override fun compare(o1: Ship, o2: Ship): Int = o1.ammunition.compareTo(o2.ammunition)
}

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    val res = shipsList.minWithOrNull(ShipComparator())
    println(res)
}