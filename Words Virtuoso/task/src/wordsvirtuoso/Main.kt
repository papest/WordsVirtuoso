package wordsvirtuoso

fun String.answer(): String {
    println(this)
    return readln()
}

const val WORD_SIZE = 5
fun main() {
    val regex = "^[a-zA-Z]{5}$".toRegex(RegexOption.IGNORE_CASE)
    val str = "Input a 5-letter string:".answer().trim()
    println(
        when {
            str.length != WORD_SIZE -> "The input isn't a $WORD_SIZE-letter string."
            str.lowercase().toSet().size < WORD_SIZE -> "The input has duplicate letters."
            !regex.matches(str) -> "The input has invalid characters."
            else -> "The input is a valid string."
        }
    )
}
