const val BOUND = 15
fun main() {
    val title = readln()

    with(title) {
        println(if (length > BOUND) "OUR LONG SONG: ${this.uppercase()}" else "our short song: ${this.lowercase()}")
    }
}