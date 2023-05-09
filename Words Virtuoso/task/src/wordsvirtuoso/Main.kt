package wordsvirtuoso

import java.io.File

const val WORD_SIZE = 5

fun validWord(word: String, wordSize: Int = WORD_SIZE): Boolean {
    val word = word.trim()
    val regex = ("\\b[a-z]{$wordSize}\\b").toRegex(RegexOption.IGNORE_CASE)
    return (word.lowercase().toSet().size == wordSize) && regex.matches(word)
}

class FileChecks(file: File) {
    private val exist = file.exists()
    private val lines = if (exist) file.readLines().map { it.trim().lowercase() }.toSet() else emptySet()
    fun fileExists() = exist
    fun invalidWordsCount() = lines.count { !validWord(it) }
    fun notIncludedWordsCount(words: FileChecks) = (lines - words.lines.toSet()).size
}

fun validFiles(words: String, candidate: String): Boolean {
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
    return true
}

const val NUMBER_OF_ARGUMENTS = 2
fun dialog(args: Array<String>) {
    if (args.size != NUMBER_OF_ARGUMENTS) {
        println("Error: Wrong number of arguments.")
        return
    }
    try {
        validFiles(args[0], args[1])
        println("Words Virtuoso")
    } catch (e: Exception) {
        println(e.message)
    }
}

fun main(args: Array<String>) {
    dialog(args)
}