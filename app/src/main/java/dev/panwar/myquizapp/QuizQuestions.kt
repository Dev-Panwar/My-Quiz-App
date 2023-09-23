package dev.panwar.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {//we are inheriting AppCompatActivity and Implementing View,OnCLickListener

    private var mCurrentPosition: Int=1
    private var mQuestionsList:ArrayList<Questions>?=null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName:String?=null
    private var mCorrectAnswers:Int=0

    private var progressBar: ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null

    private var optionOne:TextView?=null
    private var optionTwo:TextView?=null
    private var optionThree:TextView?=null
    private var optionFour:TextView?=null

    private var btnSubmit: Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)//retrieving info sent using put extra by main activity
        progressBar=findViewById(R.id.progressbar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)

        optionOne=findViewById(R.id.tv_option_one)
        optionTwo=findViewById(R.id.tv_option_two)
        optionThree=findViewById(R.id.tv_option_three)
        optionFour=findViewById(R.id.tv_option_four)
        btnSubmit=findViewById(R.id.btn_submit)

        optionOne?.setOnClickListener(this) //as we have set View.OnClickListener on Top and implemented onClick Method, this will automatically call that method with this parameter
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions() //getting question from Constant object

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()

        // Log.i("Size of QuestionList is","${questionList.size}")//to check any value in runtime in LogCat

        //        for (i in questionList){
        //            Log.e("Questions",i.questions) //this will display the value inside Question in red color in Logcat
        //        }



        val question: Questions = mQuestionsList!![mCurrentPosition - 1] //question is of type Questions and accessing Question at current position index !! because we know that it will never null
        ivImage?.setImageResource(question.image) //set image resource because our image we have stores as int
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.questions

        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPosition==mQuestionsList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"

        }
    }

    private fun defaultOptionsView(){//after every questions...get options interface back to original

        val options = ArrayList<TextView>()
        optionOne?.let {
            options.add(0,it)
        }
        optionTwo?.let {
            options.add(1,it)
        }
        optionThree?.let {
            options.add(2,it)
        }
        optionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))//color of text in options boxes get back to original
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg) //setting the box color back to original

        }

    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){//selected option look like
        mSelectedOptionPosition=selectedOptionNum
        defaultOptionsView()//first making all options default then changing selected option view
        tv.setTextColor(Color.parseColor("#363A43"))//color of text of selected option
        tv.setTypeface(tv.typeface,Typeface.BOLD)//making text bold

        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg) //setting the box color as selected option bg we created




    }
    override fun onClick(view: View?) {
         when(view?.id){
             R.id.tv_option_one ->{
                 optionOne?.let {
                     selectedOptionView(it,1)
                 }
             }
             R.id.tv_option_two ->{
                 optionTwo?.let {
                     selectedOptionView(it,2)
                 }
             }
             R.id.tv_option_three ->{
                 optionThree?.let {
                     selectedOptionView(it,3)
                 }
             }
             R.id.tv_option_four ->{
                 optionFour?.let {
                     selectedOptionView(it,4)
                 }
             }
             R.id.btn_submit ->{
                 if (mSelectedOptionPosition==0){//initially it is always zero after a question is submitted...and when we press Go To next Question submit button it is executed to set new question and then submit button rename as Submit...now we selected a option so mSelectedOptionPosition>0 so else is executed
                     mCurrentPosition++

                     when{
                         mCurrentPosition<=mQuestionsList!!.size ->{ //if current position is less than equal to the question list size than then we set question
                             setQuestion()
                         }
                         else ->{
//                             Toast.makeText(this,"You made it to End",Toast.LENGTH_LONG).show()
                             val intent= Intent(this,ResultActivity::class.java)
                             intent.putExtra(Constants.USER_NAME,mUserName) //further sending it to Result activity
                             intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                             intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                             startActivity(intent)
                             finish()
                         }
                     }
                 }
                 else{
                     val question=mQuestionsList?.get(mCurrentPosition-1)//gives the current question
                     if (question!!.correctAns!=mSelectedOptionPosition){//checking if ans is incorrect
                         answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                     }
                     else{
                         mCorrectAnswers++
                     }
                     answerView(question!!.correctAns,R.drawable.correct_option_border_bg)//showing the correct ans when user selected incorrect

                     if (mCurrentPosition == mQuestionsList!!.size){
                         btnSubmit?.text="FINISH"
                     }
                     else{
                         btnSubmit?.text="GO TO NEXT QUESTION"
                     }

                     mSelectedOptionPosition=0//so that we can set next question with above if statement
                 }

             }
         }
    }
    private fun answerView(answer:Int,drawableView:Int){//to set view of answer
        when(answer){
            1->{
                optionOne?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                optionTwo?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                optionThree?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                optionFour?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}