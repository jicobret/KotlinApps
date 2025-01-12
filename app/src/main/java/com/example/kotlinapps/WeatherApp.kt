interface Weather {
    fun displayForecast(): String
}

class Sunny : Weather {
    override fun displayForecast(): String {
        return "slonecznie"
    }
}

class Rainy : Weather {
    override fun displayForecast(): String {
        return "deszczowo"
    }
}

class Cloudy : Weather {
    override fun displayForecast(): String {
        return "pochmurno"
    }
}

data class City(val name: String, val weather: Weather)

val cities = listOf(
    City("olsztyn", Rainy()),
    City("warszawa", Sunny()),
    City("krakow", Rainy()),
    City("gdansk", Cloudy()),
    City("wroclaw", Sunny()),
    City("poznan", Cloudy())
)

fun main() {
    while (true) {
        println("wybierz miasto:")
        cities.forEachIndexed { index, city ->
            println("${index + 1}. ${city.name}")
        }

        val choice = readln().toInt()
        if (choice in 1..cities.size) {
            val selectedCity = cities[choice - 1]
            println("${selectedCity.name}: ${selectedCity.weather.displayForecast()}")
        }else {
            println("nieprawidlowy wybor")
        }
        println()
    }
}
