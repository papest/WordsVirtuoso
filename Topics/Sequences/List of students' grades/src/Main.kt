const val PASSING_GRADE = 5
fun main() {
    val listOfGrades = readln().split(" ").map { it.toDouble() }.asSequence()
    println(listOfGrades.filter { it > PASSING_GRADE }.average())
}