package edu.uw.eep523.tipcalculatorexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var seekBarPercentage: Int = 0
    private var billAmount: Float = 0f
    private var tipAmount: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar_id.max = 100

        seekBar_id.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarTextView_id.text = getString(R.string.tip_percent) + "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBarTextView_id.text = getString(R.string.tip_percent) + seekBar_id.progress
                seekBarPercentage = seekBar_id.progress
            }
        })
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View) {
                calculate()
            }
        })
    }

    fun calculate(){
        if(billAmountEditText_id.text.toString() == "")
            show_toast("Enter a valid amount")
        else {
            billAmount = billAmountEditText_id.text.toString().toFloat()
            tipAmount = billAmount.toFloat() * seekBarPercentage / 100
            tipTextView_id.text = getString(R.string.tip_amount) + " %.2f".format(tipAmount)
            TotalTextView.text =  getString(R.string.total_amount) + " %.2f".format(billAmount + tipAmount)
        }
    }

    fun show_toast(textToShow:String){
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, textToShow, duration)
        toast.setGravity(Gravity.TOP or Gravity.LEFT, 50, 500)
        toast.show()
    }
}

