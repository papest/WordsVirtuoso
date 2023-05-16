data class Client(val name: String, val age: Int) {
// equals only for name and age
    val balance: Int = readln().toInt()
}

fun main() {
    println(
        Client(readln(), readln().toInt()) == Client(
            readln(),
            readln().toInt(),
        )
    )
}