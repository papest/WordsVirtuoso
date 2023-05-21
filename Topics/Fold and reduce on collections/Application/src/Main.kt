data class Ship(val name: String, val ammunition: Int)
@SuppressWarnings("MagicNumber")
fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    val res = shipsList.fold(0) { acc, it ->
        if (it.name.startsWith('T') && it.ammunition > 20) acc + it.ammunition else acc
    }
    println(res)
}