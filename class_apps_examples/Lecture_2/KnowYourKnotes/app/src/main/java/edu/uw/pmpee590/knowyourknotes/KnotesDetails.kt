package edu.uw.eep523.knowyourknotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_knotes_details.*

import androidx.appcompat.app.AppCompatActivity

const val KEY_SECOND = "KEY_SECOND"
class KnotesDetails : AppCompatActivity() {
/*
    //The text can be hardcode in this section
    // but to show an example, the text is read files located in the res/raw folder

    var figure8_desc:String = "With a long bight in the rope use two double loops to tie a Figure 8 knot. Then pass the end of the original bight under, up, and over the whole knot. Pull it tight to lock the two loops."
    var butterfly_desc: String = "Join the two ends temporarily. Wind the rope around your hand so that the join is by your finger tips. Go around again. Fold the join back and then up under the other ropes. Push the knot off your hand and tighten to see the appearance of the Alpine Butterfly. Finally, release the temporary join."
    var stopper_desc:String = "Form a loop in the rope. Pass the end through it. Pass the end through the loop again. Tighten the knot to make a secure stopper knot."
    var fisherman_desc :String = "Overlap the two ends. Wrap one end around both ropes two full turns. Then pass this end back through these turns and pull tight. Next pass the other end two full turns around both ropes. Pass this end back through and pull tight. Pull on both ropes to tighten the two knots against each other."
    val list = mutableListOf(figure8_desc,butterfly_desc,stopper_desc,fisherman_desc)
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knotes_details)
        val id = intent.getIntExtra(KEY_MAIN, R.id.figure8)
        update_knot_info(id)

    }


    fun update_knot_info(id:Int){
        val file_name = getResources().getResourceEntryName(id);
        val textFiledID = resources.getIdentifier(file_name, "raw", packageName)
        val fileRead= resources.openRawResource(textFiledID).bufferedReader().readText()
        knote_info.text = fileRead

   }

    fun onclickSubmit(view: View) {
        val user_text = user_description.text.toString()
        val intent = Intent()
        intent.putExtra(KEY_SECOND, user_text)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }




}
