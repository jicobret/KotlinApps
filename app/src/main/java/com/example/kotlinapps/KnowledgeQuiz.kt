interface Question {
    fun askQuestion(): String
    fun checkAnswer(answer: String): Boolean
}

class MultipleChoiceQuestion(
    private val question: String,
    private val options: List<String>,
    private val correctOption: Int
) : Question {

    override fun askQuestion(): String {
        return "$question\n" + options.mapIndexed { index, option -> "${index + 1}. $option" }.joinToString("\n")
    }

    override fun checkAnswer(answer: String): Boolean {
        return answer.toInt() == correctOption
    }
}

class TrueFalseQuestion(
    private val question: String,
    private val correctAnswer: Boolean
) : Question {
    override fun askQuestion(): String {
        return "$question (true/false)"
    }

    override fun checkAnswer(answer: String): Boolean {
        return answer.equals(correctAnswer.toString(), ignoreCase = true)
    }
}

fun main() {
    val questions: List<Question> = listOf(
        MultipleChoiceQuestion(
            "co jest stolica polski?",
            listOf("olsztyn", "warszawa", "elblag", "moskwa"),
            2
        ),
        TrueFalseQuestion(
            "ziemia jest plaska",
            false
        ),
        MultipleChoiceQuestion(
            "w jakim jezyku programowania napisano ta aplikacje?",
            listOf("c#", "kotlin", "javascript", "python"),
            2
        ),
        TrueFalseQuestion(
            "2+2=4",
            true
        )
    )
    var correctAnswers = 0

    for (question in questions) {
        println(question.askQuestion())
        val userAnswer = readln()
        if (question.checkAnswer(userAnswer)) {
            println("poprawna odpowiedz!")
            correctAnswers++
        } else {
            println("zla odpowiedz")
        }
        println()
    }
    println("koniec quizu! poprawnie odpowiedziales na $correctAnswers/${questions.size} pytan.")
}
