package edu.uw.eep523.listviewexample

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myStringArray: Array<String> = arrayOf("Burpees", "crunches", "Squats","aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","Burpees", "crunches", "Squats")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray)
        val listView: ListView = list_view
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            myview.text =myStringArray[position]

        }
    }
}
