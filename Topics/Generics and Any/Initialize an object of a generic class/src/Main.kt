class Holder<T>(val value: T) {

    fun get(): T {
        return value
    }
}

fun main() {
    val holder = Holder("This is an instance of String")
    val holderValue = holder.get()
    print(holderValue)
}