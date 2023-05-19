data class User(val name: String, val age: Int, val email: String)

class UserComparator : Comparator<User> {
    override fun compare(u1: User, u2: User): Int {
        return if (u1.age - u2.age == 0) u1.name.compareTo(u2.name) else u1.age - u2.age
    }
}
