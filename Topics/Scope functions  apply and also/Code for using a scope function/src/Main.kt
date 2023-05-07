fun main() {
    var a = readln()
    var b = readln()
    b = a.apply { a = b }

    println(a)
    println(b)
}