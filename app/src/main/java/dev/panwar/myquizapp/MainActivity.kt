package dev.panwar.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button=findViewById(R.id.btnStart)
        val etName: EditText=findViewById(R.id.et_name)//name entered by user

        btnStart.setOnClickListener {

            if (etName.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent=Intent(this,QuizQuestions::class.java)//to move from one activity to another activity(i.e screen)//this means from here to QuizQuestions::class.java Syntax
                intent.putExtra(Constants.USER_NAME,etName.text.toString())//sending extra info to other Activity
                startActivity(intent)//to start activity
                finish()//so that on pressing back button we do not get back to prev. screen or activity
            }
        }

    }
}