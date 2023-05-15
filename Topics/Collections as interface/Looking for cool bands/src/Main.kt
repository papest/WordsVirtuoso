fun main() {
    val listOfDishes = readln().split(", ").toList()
    val setOfDishes = listOfDishes.toSet()
    val keyWord = readln()

    println(findBands(listOfDishes, keyWord))
    println(findBands(setOfDishes, keyWord))
}

fun findBands(collection: Collection<String>, keyWord: String): List<String> =
    collection.filter { it.contains(keyWord, true) }
