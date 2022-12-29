package com.wd.ktdemo.activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.wd.ktdemo.R


/**
 * @author wudi
 * @desc
 * @time 2022-12-29 11:15
 */
class SpinnerActivity : AppCompatActivity(){

    val categories = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        var edt=findViewById<EditText>(R.id.edt)
        categories.add("shubham")
        categories.add("karan")
        categories.add("arjun")
        categories.add("arsh")
        var spinner=findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, R.layout.color_spinner_layout, categories)
        spinner.adapter = adapter
        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.e("TAG", "position: $position")
                edt.setText(categories.get(position))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }




    }
}