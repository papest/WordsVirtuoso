package wordsvirtuoso

import java.io.File
import kotlin.random.Random

const val WORD_SIZE = 5

fun String.answer(): String {
    println(this)
    return readln()
}

fun validWord(word: String, wordSize: Int = WORD_SIZE): Boolean {
    val regex = ("\\b[A-Z]{$wordSize}\\b").toRegex(RegexOption.IGNORE_CASE)
    with(word.trim().lowercase()) {
        return (toSet().size == wordSize) && regex.matches(this)
    }
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
    val secret = candidateCheck.run { lines.toMutableList()[Random.nextInt(0, lines.size)].uppercase() }
    val start = System.currentTimeMillis()
    val tries = mutableListOf<MutableList<Pair<Char, Color>>>()
    var word = "Input a $WORD_SIZE-letter word:".answer().trim().uppercase()
    val badChars = mutableSetOf<Char>()
    while (true) {
        when {
            word == "EXIT" -> {
                println("The game is over.")
                break
            }
            word == secret -> {
                val end = System.currentTimeMillis()
                val duration = end - start
                tries.add(word.map { it to Color.GREEN }.toMutableList())
                tries.forEach { printColorWord(it) }
                println("Correct!")
                println(
                    if (tries.size == 1) "Amazing luck! The solution was found at once." else "The solution was" +
                            " found after ${tries.size} tries in $duration seconds."
                )
                break
            }
            word.length != WORD_SIZE -> println("The input isn't a $WORD_SIZE-letter word.")
            !"[A-Z]+".toRegex().matches(word) -> println("One or more letters of the input aren't valid.")
            word.toSet().size != WORD_SIZE -> println("The input has duplicate letters.")
            !wordsCheck.lines.contains(word.lowercase()) -> println("The input word isn't included in my words list.")
            else -> word.indices.map {
                when {
                    !secret.contains(word[it]) -> {
                        badChars.add(word[it])
                        word[it] to Color.GREY
                    }
                    word[it] == secret[it] -> word[it] to Color.GREEN
                    else -> word[it] to Color.YELLOW
                }
            }.toMutableList().run {
                tries.add(this)
                tries.forEach { printColorWord(it) }
                println()
                with(badChars.sorted().joinToString("")) {
                    println("${Color.AZURE.sequence}$this$RESET\n")
                }
            }
        }

        word = "Input a $WORD_SIZE-letter word:".answer().trim().uppercase()
    }
}

fun printColorWord(word: MutableList<Pair<Char, Color>>) {
//    var curWord = word
//    while (curWord.isNotEmpty()) {
//        val color = curWord.first().second
//        curWord.takeWhile {
//            color == it.second
//        }.map { it.first }.joinToString("")
//            .let {
//            print("${color.sequence}$it$RESET")
//        }
//        curWord = curWord.dropWhile { it.second == color }.toMutableList()
//    }
    word.forEach {
        print("${it.second.sequence}${it.first}$RESET")
    }
    println()
}

const val RESET = "\u001B[0m"

enum class Color(val sequence: String) {
    GREEN("\u001B[48:5:10m"),
    YELLOW("\u001B[48:5:11m"),
    GREY("\u001B[48:5:7m"),
    AZURE("\u001B[48:5:14m")
}

fun main(args: Array<String>) {
    dialog(args)
}