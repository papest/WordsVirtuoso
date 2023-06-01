data class Ship(val name: String, val ammunition: Int) {
    override fun toString(): String {
        return "$name-$ammunition"
    }
}

const val LOWER_LIMIT = 20

fun main() {
    val ships = readln().split(" ")
    val shipsSequence = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }.asSequence()
    println(shipsSequence.filter { it.ammunition > LOWER_LIMIT }.map { it.name }.sorted().toList())
}