package dev.panwar.myquizapp

object Constants {

    const val USER_NAME: String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS: String="correct_answer"

    fun getQuestions():ArrayList<Questions>{

        val questionList = ArrayList<Questions>()
        //1
        val ques1=Questions(//giving input to data class blueprint//constructor of data class
           1, "What Country Does this Flag belong to?",
            R.drawable.ic_india,
            "India","Australia","Dubai","America",
            1
        )

        questionList.add(ques1)

        //2

        val ques2=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_argentina,
            "India","Australia","Dubai","Argentina",
            4
        )

        questionList.add(ques2)

        //3

        val ques3=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_australia,
            "India","Australia","Kuwait","America",
            2
        )

        questionList.add(ques3)

        //4

        val ques4=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_belgium,
            "Belgium","Germany","Dubai","America",
            1
        )

        questionList.add(ques4)

        //5

        val ques5=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_brazil,
            "Argentina","Australia","Brazil","America",
            3
        )

        questionList.add(ques5)

        //6

        val ques6=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_fiji,
            "India","Fiji","Dubai","America",
            2
        )

        questionList.add(ques6)

        //7

        val ques7=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_germany,
            "Germany","Australia","Dubai","America",
            1
        )

        questionList.add(ques7)

        //8

        val ques8=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_kuwait,
            "Pakistan","Australia","Kuwait","America",
            3
        )

        questionList.add(ques8)

        //9

        val ques9=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_newzealand,
            "India","Australia","Dubai","New Zealand",
            4
        )

        questionList.add(ques9)

        //10

        val ques10=Questions(//giving input to data class blueprint//constructor of data class
            1, "What Country Does this Flag belong to?",
            R.drawable.ic_denmark,
            "Denmark","Australia","England","Russia",
            1
        )

        questionList.add(ques10)



     return  questionList
    }

}