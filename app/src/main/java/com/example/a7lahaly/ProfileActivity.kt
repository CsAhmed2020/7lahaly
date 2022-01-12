package com.example.a7lahaly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSimpleSpinner()
    }

    fun setSimpleSpinner() {
        ArrayAdapter.createFromResource(
            this,
            R.array.faculty_arrays,
            R.layout.list_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                if (parent!!.getItemAtPosition(pos).equals("your faculty"))
                {
                    //do nothing.
                }
                else
                {

                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        })
    }
}