package edu.uw.ecepmp590.olimpicsquiz

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mCurrentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCurrentIndex = 0
    }

    //A list of Question objects.
    // Every question is an object of the class Question
    private val questionBank = listOf(
        Question(R.string.q1, false),
        Question(R.string.q2, false),
        Question(R.string.q3, false),
        Question(R.string.q4, true),
        Question(R.string.q5, true),
        Question(R.string.q6, true),
        Question(R.string.q7, false),
        Question(R.string.q8, true),
        Question(R.string.q9, true),
        Question(R.string.q10, false)
    )


    fun updateQuestion(view: View){
        mCurrentIndex ++

        if (mCurrentIndex >= questionBank.size) {
            mCurrentIndex = 1
        }
        val questionTextResID = questionBank[mCurrentIndex].textResId
        questionView.setText(questionTextResID)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[mCurrentIndex].answer
        if(userAnswer == correctAnswer){
            val text = " =D  Correct!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 0)
            toast.show()

            //show_snackbar(text)
            //show_custom_snackbar(text)
        }
        else{
            val text = ":P not correct"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 0)
            toast.show()
            //show_snackbar(text)
            //show_custom_snackbar(text)
        }
     }

    //Function which is executed when the user press on the True Botton
    fun check_true(view: View){
        checkAnswer(true)
    }

    //Function which is executed when the user press on the False Botton
    fun check_false(view: View){
        checkAnswer(false)
    }


 //Example function to show a snackbar to notify the user the result of the guess
    fun show_snackbar(text:String){
        Snackbar.make(
            myLayout,
            text,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    //Example function to show a snackbar to notify the user the result of the guess
    //This snackbar includes an action item.
    fun show_custom_snackbar(text:String){
        val snackbar =
            Snackbar.make(myLayout, text, Snackbar.LENGTH_LONG)
        snackbar.setAction(
            "ACTION"
        ) { Toast.makeText(applicationContext, "ACTION FROM SNACKBAR", Toast.LENGTH_SHORT).show() }

        snackbar.setActionTextColor(Color.WHITE)

        val snackbarView = snackbar.view
        val snackbarText =
            snackbarView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        snackbarText.setTextColor(Color.YELLOW)
        snackbar.show()
    }
}
