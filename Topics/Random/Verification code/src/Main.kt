const val LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789"
const val LENGTH = 10
fun verificationCode(): String = List(LENGTH) { LETTERS.random() }.joinToString("")
