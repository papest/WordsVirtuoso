data class Person(val name: String, val age: Int)

@SuppressWarnings("MagicNumber")
fun main() {
    val people = listOf(
        Person("John", 25),
        Person("Sarah", 30),
        Person("David", 20),
        Person("Alice", 40)
    )

    val comparator = Comparator<Person> { p1, p2 -> p2.age - p1.age }
    val sortedPeople = people.sortedWith(comparator)

    sortedPeople.forEach { println("${it.name}, ${it.age}") }
}