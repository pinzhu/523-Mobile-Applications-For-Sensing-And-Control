package edu.uw.eep523.mrpotato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkboxClickForAll(view: View) {

        // check which check box is checked
        // very cool way
        val myCheckBoxChecked = (view as CheckBox).isChecked
        when (view.getId()) {
            R.id.armsBox -> if (myCheckBoxChecked) {
                arms.visibility= View.VISIBLE
            } else {
                arms.visibility = View.INVISIBLE
            }
            R.id.earsBox -> if (myCheckBoxChecked) {
                ears.visibility = View.VISIBLE
            } else {
                ears.visibility = View.INVISIBLE
            }
            R.id.eyebrowsBox -> if (myCheckBoxChecked) {
                eyebrows.visibility = View.VISIBLE
            } else {
                eyebrows.visibility = View.INVISIBLE
            }
            R.id.eyesBox -> if (myCheckBoxChecked) {
                eyes.visibility = View.VISIBLE
            } else {
                eyes.visibility = View.INVISIBLE
            }
            R.id.glassesBox -> if (myCheckBoxChecked) {
                glasses.visibility = View.VISIBLE
            } else {
                glasses.visibility = View.INVISIBLE
            }
            R.id.hatBox -> if (myCheckBoxChecked) {
                hat.visibility = View.VISIBLE
            } else {
                hat.visibility = View.INVISIBLE
            }
            R.id.mouthBox -> if (myCheckBoxChecked) {
                mouth.visibility = View.VISIBLE
            } else {
                mouth.visibility = View.INVISIBLE
            }
            R.id.noseBox -> if (myCheckBoxChecked) {
                nose.visibility = View.VISIBLE
            } else {
                nose.visibility = View.INVISIBLE
            }
            R.id.shoesBox -> if (myCheckBoxChecked) {
                shoes.visibility = View.VISIBLE
            } else {
                shoes.visibility = View.INVISIBLE
            }
            R.id.mustacheBox -> if (myCheckBoxChecked) {
                mustache.visibility = View.VISIBLE
            } else {
                mustache.visibility = View.INVISIBLE
            }
        }
    }
}