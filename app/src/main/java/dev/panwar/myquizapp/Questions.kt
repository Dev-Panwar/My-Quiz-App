package dev.panwar.myquizapp

data class Questions(
//parameters of data class
    val id: Int,
    val questions: String,
    val image: Int,//background it is treated as int

    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,

    val correctAns: Int//index of correct ans like 1,2,3,4



)
