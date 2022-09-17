package khan.sajad.example.quiztime

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        questionList.add(
            Question(1, "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "India",
            "Mexico",
            "Argentina",
            "Angola",
            3)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_india,
                "India",
                "Mexico",
                "Argentina",
                "Angola",
                1)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Britain",
                "Mexico",
                "Australia",
                "Angola",
                3)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_austria,
                "Austria",
                "Portugal",
                "Uganda",
                "Angola",
                1)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Qatar",
                "Kuwait",
                "Lebanon",
                "Peru",
                2)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_afghanistan,
                "Japan",
                "Portugal",
                "Taiwan",
                "Afghanistan",
                4)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Brazil",
                "Portugal",
                "Uganda",
                "Angola",
                1)
        )
        questionList.add(
            Question(1, "Which country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Austria",
                "Portugal",
                "Denmark",
                "Angola",
                3)
        )
        return questionList
    }
}