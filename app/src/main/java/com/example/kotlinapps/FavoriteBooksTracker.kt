data class Book(val title: String, val author: String, val year: Int)

object BookTracker {
    private val books = mutableListOf<Book>()

    fun addBook(title: String, author: String, year: Int) {
        if (title.isNotBlank() && author.isNotBlank()) {
            books.add(Book(title, author, year))
            println("Książka została dodana.")
        } else {
            println("Tytuł i autor nie mogą być puste.")
        }
    }

    fun filterByAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }

    fun filterByYear(year: Int): List<Book> {
        return books.filter { it.year == year }
    }

    fun sortBooksByTitle(): List<Book> {
        return books.sortedBy { it.title }
    }

    fun displayAllBooks(): List<Book> {
        return books
    }
}

fun main() {
    while (true) {
        println("wybierz opcje:")
        println("1. dodaj nowa ksiazke")
        println("2. filtruj ksiazki wg. autora")
        println("3. filtruj ksiazki wg. roku wydania")
        println("4. sortuj ksiazki alfabetycznie")
        println("5. wyswietl wszystkie ksiazki")

        when (readln()) {
            "1" -> {
                println("podaj tytul:")
                val title = readln()
                println("podaj autora:")
                val author = readln()
                println("podaj rok wydania:")
                val year = readln().toInt()
                BookTracker.addBook(title, author, year)
            }
            "2" -> {
                println("podaj imie autora:")
                val author = readln()
                val filteredBooks = BookTracker.filterByAuthor(author)
                if (filteredBooks.isNotEmpty()) {
                    println("oto ksiazki autora $author:")
                    filteredBooks.forEach { println(it) }
                } else {
                    println("brak ksiazek autora $author")
                }
            }
            "3" -> {
                println("podaj rok wydania:")
                val year = readln().toInt()
                val filteredBooks = BookTracker.filterByYear(year)
                if (filteredBooks.isNotEmpty()) {
                    println("oto ksiazki z $year:")
                    filteredBooks.forEach { println(it) }
                } else {
                    println("brak ksiazek z $year.")
                }
            }
            "4" -> {
                BookTracker.sortBooksByTitle().forEach { println(it) }
            }
            "5" -> {
                BookTracker.displayAllBooks().forEach { println(it) }
            }
            else -> println("nieprawidlowa opcja")
        }
        println()
    }
}
