class StepCounter {
    companion object {
        private var steps = 0
        fun step() {
            steps++
            println("wykonano krok, liczba krokow: $steps")
        }

        fun reset() {
            steps = 0
            println("zresetowano liczbe krokow")
        }

        fun getSteps(): Int {
            return steps
        }
    }
}

fun main() {
    while (true) {
        println("wybierz opcje:")
        println("1. zrob krok")
        println("2. wyswietl liczbe krokow")
        println("3. zresetuj licznik")

        when (readln()) {
            "1" -> StepCounter.step()
            "2" -> println("${StepCounter.getSteps()}")
            "3" -> StepCounter.reset()
            else -> println("nieprawidlowa opcja")
        }
        println()
    }
}
