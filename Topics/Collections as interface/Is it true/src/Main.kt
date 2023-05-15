fun checkElements(nameList: MutableCollection<String>, name: String): Boolean = nameList.any { it == name }

fun main() {
    val nameList = readln().split(" ").toMutableList()
    val nameSet = nameList.toMutableSet()
    val name = readln()

    println(checkElements(nameList, name))
    println(checkElements(nameSet, name))
}
