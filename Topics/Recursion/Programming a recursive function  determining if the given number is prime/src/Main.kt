fun isPrime(n: Int, i: Int = 2): Boolean {
    return when {
        n == 1 -> false
        n <= i -> true
        n % i == 0 -> false
        else -> isPrime(n, i + 1)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    print(isPrime(n))
}