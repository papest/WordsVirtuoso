import kotlin.random.Random
@SuppressWarnings("MagicNumber")
fun rpgDices(dice1: Int, dice2: Int): Int =
    Random.nextInt(2, dice1 + dice2 + 1)