import kotlin.random.Random

interface RollingTool {
    fun roll(): String
}

class Coin : RollingTool {
    override fun roll(): String {
        return if (Random.nextBoolean()) "orzel" else "reszka"
    }
}

class Dice : RollingTool {
    override fun roll(): String {
        return (1..6).random().toString()
    }
}

fun main() {
    while (true) {
        println("wybierz opcje:")
        println("1. rzut moneta")
        println("2. rzut koscia")

        when (readln()) {
            "1" -> {
                val coin = Coin()
                println("wynik rzutu moneta: ${coin.roll()}")
            }
            "2" -> {
                val dice = Dice()
                println("wynik rzutu koscia: ${dice.roll()}")
            }
            else -> println("nieprawidlowa opcja")
        }
        println()
    }
}
