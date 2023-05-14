fun main() {
    var word1 = readln()
    var word2 = readln()
    if (word1.length > word2.length) word1 = word2.also { word2 = word1 }

    println(
        word1.indices.joinToString("") { "${word1[it]}${word2[it]}" } +
                if (word2.length > word1.length) word2.substring(word1.length, word2.length) else ""
    )
}