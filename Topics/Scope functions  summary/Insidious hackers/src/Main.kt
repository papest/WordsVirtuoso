fun main() {
    val title = readln()
    title
        .removePrefix("he-he-he")
        .let { "$it with great actor Ryan Gosling" }
        .uppercase()
        .also(::println)
}