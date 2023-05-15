fun main() {
    val oldList = readln().split(" ").toMutableList()
    val oldSet = oldList.toMutableSet()
    val addedList = readln().split(" ").toList()

    addListToCollection(oldList, addedList)
    addListToCollection(oldSet, addedList)

    println(oldList.joinToString(" "))
    println(oldSet.joinToString(" "))
}

fun addListToCollection(collection: MutableCollection<String>, addedList: List<String>) = collection.addAll(addedList)
