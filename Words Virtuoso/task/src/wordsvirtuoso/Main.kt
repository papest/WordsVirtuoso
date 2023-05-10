package wordsvirtuoso

import java.io.File
import kotlin.random.Random

const val WORD_SIZE = 5

fun String.answer(): String {
    println(this)
    return readln()
}

fun validWord(word: String, wordSize: Int = WORD_SIZE): Boolean {
    val word = word.trim()
    val regex = ("\\b[a-z]{$wordSize}\\b").toRegex(RegexOption.IGNORE_CASE)
    return (word.lowercase().toSet().size == wordSize) && regex.matches(word)
}

class FileChecks(file: File) {
    private val exist = file.exists()
    val lines = if (exist) file.readLines().map { it.trim().lowercase() }.toSet() else emptySet()
    fun fileExists() = exist
    fun invalidWordsCount() = lines.count { !validWord(it) }
    fun notIncludedWordsCount(words: FileChecks) = (lines - words.lines.toSet()).size

}

fun validFiles(words: String, candidate: String): Pair<FileChecks, FileChecks> {
    val wordsChecks = FileChecks(File(words))
    val candidateChecks = FileChecks(File(candidate))
    if (!wordsChecks.fileExists()) throw Exception("Error: The words file $words doesn't exist.")
    if (!candidateChecks.fileExists()) throw Exception("Error: The candidate words file $candidate doesn't exist.")
    wordsChecks.invalidWordsCount().let {
        if (it != 0) throw Exception("Error: $it invalid words were found in the $words file.")
    }
    candidateChecks.invalidWordsCount().let {
        if (it != 0) throw Exception("Error: $it invalid words were found in the $candidate file.")
    }
    candidateChecks.notIncludedWordsCount(wordsChecks).let {
        if (it != 0) throw Exception("Error: $it candidate words are not included in the $words file.")
    }
    return Pair(wordsChecks, candidateChecks)
}

const val NUMBER_OF_ARGUMENTS = 2
fun dialog(args: Array<String>) {
    if (args.size != NUMBER_OF_ARGUMENTS) {
        println("Error: Wrong number of arguments.")
        return
    }
    try {
        val checks = validFiles(args[0], args[1])
        println("Words Virtuoso")
        game(checks.first, checks.second)
    } catch (e: Exception) {
        println(e.message)
    }
}

fun game(wordsCheck: FileChecks, candidateCheck: FileChecks) {
    val secret = candidateCheck.run { lines.toMutableList()[Random.nextInt(0, lines.size)] }
    var word = "Input a $WORD_SIZE-letter word:".answer().trim().lowercase()
    while (true) {
        when {
            word == "exit" -> {
                println("The game is over.")
                break
            }
            word == secret -> {
                println("Correct!")
                break
            }
            word.length != WORD_SIZE -> println("The input isn't a $WORD_SIZE-letter word.")
            !"[a-z]+".toRegex().matches(word) -> println("One or more letters of the input aren't valid.")
            word.toSet().size != WORD_SIZE -> println("The input has duplicate letters.")
            !wordsCheck.lines.contains(word) -> println("The input word isn't included in my words list.")
            else -> word.indices.map {
                when {
                    !secret.contains(word[it]) -> '_'
                    word[it] == secret[it] -> word[it].uppercaseChar()
                    else -> word[it]
                }
            }.joinToString("").run { println(this) }
        }
        word = "Input a $WORD_SIZE-letter word:".answer().trim().lowercase()
    }
}

fun main(args: Array<String>) {
    dialog(args)
}