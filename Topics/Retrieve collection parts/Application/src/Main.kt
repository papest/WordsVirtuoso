data class Ship(val name: String, val ammunition: Int)

const val CHUNK_SIZE = 3
fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    println(shipsList.map { it.ammunition }.chunked(CHUNK_SIZE) { it.sum() / it.size })
}