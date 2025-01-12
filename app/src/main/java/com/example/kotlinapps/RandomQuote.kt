object Quotes {
    private val quotes = mutableListOf(
        "The only limit to our realization of tomorrow is our doubts of today.",
        "Life is what happens when you're busy making other plans.",
        "Do not wait to strike till the iron is hot, but make it hot by striking.",
        "The future belongs to those who believe in the beauty of their dreams."
    )

    fun getRandomQuote(): String {
        return quotes.random()
    }

    fun addQuote(quote: String) {
        if (quote.isNotBlank()) {
            quotes.add(quote)
            println("dodano cytat")
        } else {
            println("pole nie moze byc puste")
        }
    }
}

fun main() {
    while (true) {
        println("wybierz opcje:")
        println("1. wyswietl losowy cytat")
        println("2. dodaj cytat")

        when (readln()) {
            "1" -> println(Quotes.getRandomQuote())
            "2" -> {
                println("wpisz nowy cytat: ")
                val newQuote = readlnOrNull()
                if (newQuote != null) {
                    Quotes.addQuote(newQuote)
                } else {
                    println("nieprawidlowe dane")
                }
            }
            else -> println("nieprawidlowa opcja")
        }
        println()
    }
}
