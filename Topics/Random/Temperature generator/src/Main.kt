import kotlin.random.Random
@SuppressWarnings("MagicNumber")
fun generateTemperature(seed: Int): String =
    with(Random(seed)) { List(7) { nextInt(20, 31) }.joinToString(" ") }
