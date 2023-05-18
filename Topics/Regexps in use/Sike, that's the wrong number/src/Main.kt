fun main() {
    readln()
        .replace("[a-zA-z]".toRegex(), "")
        .also(::println)
}