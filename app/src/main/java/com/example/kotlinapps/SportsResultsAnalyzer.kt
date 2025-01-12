data class MatchResult(val points: Int)

object SportsResultsAnalyzer {
    private val results = mutableListOf<MatchResult>()

    fun addResult(points: Int) {
        if (points >= 0) {
            results.add(MatchResult(points))
            println("dodano wynik: $points pkt.")
        } else {
            println("wynik meczu nie moze byc ujemny")
        }
    }

    fun filterResults(threshold: Int): List<MatchResult> {
        return results.filter { it.points > threshold }
    }

    fun addBonusPoints(bonus: Int) {
        for (i in results.indices) {
            results[i] = results[i].copy(points = results[i].points + bonus)
        }
        println("dodano $bonus pkt. do wynikow")
    }

    fun sumResults(): Int {
        return results.sumOf { it.points }
    }

    fun maxResult(): Int {
        return results.maxOfOrNull { it.points } ?: 0
    }

    fun differenceBetweenMaxAndMin(): Int {
        val max = results.maxOfOrNull { it.points } ?: 0
        val min = results.minOfOrNull { it.points } ?: 0
        return max - min
    }

    fun countMatchesAbove(threshold: Int): Int {
        return results.count { it.points > threshold }
    }

    fun displayResults() {
        if (results.isEmpty()) {
            println("brak wynikow")
        } else {
            println("wyniki:")
            results.forEach { println("${it.points} pkt.") }
        }
    }
}

fun main() {
    while (true) {
        println("wybierz opcje")
        println("1. dodaj wynik meczu")
        println("2. filtruj wyniki powyzej progu")
        println("3. dodaj punkty bonusowe")
        println("4. wyswietl sume wynikow")
        println("5. wyswietl maksymalny wynik")
        println("6. wyswietl roznice miedzy najwiekszym a najmniejszym wynikiem")
        println("7. zlicz mecze powyzej progu")
        println("8. wyswietl wszystkie wyniki")

        when (readln()) {
            "1" -> {
                println("podaj liczbe punktow:")
                val points = readln().toInt()
                SportsResultsAnalyzer.addResult(points)
            }
            "2" -> {
                println("podaj prog:")
                val threshold = readln().toInt()
                val filtered = SportsResultsAnalyzer.filterResults(threshold)
                if (filtered.isNotEmpty()) {
                    println("wyniki powyzej $threshold pkt:")
                    filtered.forEach { println("${it.points} pkt") }
                } else {
                    println("brak wynikow powyzej $threshold pkt.")
                }
            }
            "3" -> {
                println("podaj ilosc bonusowych punktow:")
                val bonus = readln().toInt()
                SportsResultsAnalyzer.addBonusPoints(bonus)
            }
            "4" -> println("${SportsResultsAnalyzer.sumResults()} pkt.")
            "5" -> println("${SportsResultsAnalyzer.maxResult()} pkt.")
            "6" -> println("${SportsResultsAnalyzer.differenceBetweenMaxAndMin()} pkt.")
            "7" -> {
                println("podaj prog:")
                val threshold = readln().toInt()
                val count = SportsResultsAnalyzer.countMatchesAbove(threshold)
                println("liczba meczow z wynikiem powyzej $threshold pkt.: $count")
            }
            "8" -> SportsResultsAnalyzer.displayResults()
            else -> println("nieprawidlowa opcja.")
        }
        println()
    }
}
