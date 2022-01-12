package com.example.a7lahaly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val result_btn: Button = findViewById(R.id.result_btn)

        result_btn.setOnClickListener(View.OnClickListener {
            var intent : Intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        })
    }
}