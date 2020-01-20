package com.example.helloworlddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompatExtras
import kotlinx.android.synthetic.main.activity_main.view.*
import work.nbcc.quiz.Question

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    private var questionIndex = 0

    private lateinit var questionView :TextView

    private lateinit var  nextButton: Button

    private lateinit var prevButton: Button

    private lateinit var trueButton: Button

    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.question_view)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        questionView.setText(questionBank[questionIndex].TextResID)


        trueButton.setOnClickListener{
            if(questionBank[questionIndex].answer == true){
                val text = "Correct!!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
            else{
                val text = "Incorrect!!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
        falseButton.setOnClickListener{
            if(questionBank[questionIndex].answer == false){
                val text = "Correct!!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
            else {
                val text = "Incorrect!!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
        nextButton.setOnClickListener{
            questionIndex = (questionIndex + 1) % 20
            questionView.setText(questionBank[questionIndex].TextResID)
        }
        prevButton.setOnClickListener{
            questionIndex =
                if(questionIndex == 0)
                {
                    19
                }  else {
                    questionIndex--
                }
            questionView.setText(questionBank[questionIndex].TextResID)

        }


    }
}
