fun main() {
    with(readln().split(" ").filter { it.first() in 'a'..'l' }) {
        println(minByOrNull { it.length })
    }
}