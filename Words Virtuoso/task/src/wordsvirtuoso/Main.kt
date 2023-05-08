package wordsvirtuoso

import java.io.File
import java.util.*

fun String.answer(): String {
    println(this)
    return readln()
}

const val WORD_SIZE = 5

fun validWord(word: String, wordSize: Int = WORD_SIZE): Boolean {
    val word = word.trim()
    val regex = ("\\b[a-z]{$wordSize}\\b").toRegex(RegexOption.IGNORE_CASE)
    return word.lowercase().toSet().size == wordSize && regex.matches(word)
}

fun main() {
    val fileName = "Input the words file:".answer()
    val file = File(fileName)
    var invalidWordsCount = 0
    try {
        val scanner = Scanner(file)
        while (scanner.hasNext()) {
            val word = scanner.nextLine()
            if (!validWord(word)) invalidWordsCount++
        }
        println(
            if (invalidWordsCount == 0) "All words are valid!"
            else "Warning: $invalidWordsCount invalid words were found in the $fileName file."
        )
    } catch (e: Exception) {
        println("Error: The words file $fileName doesn't exist.")
    }
}
