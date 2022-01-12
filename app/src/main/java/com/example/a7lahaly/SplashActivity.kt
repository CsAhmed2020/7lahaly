package com.example.a7lahaly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.os.HandlerCompat.postDelayed


class SplashActivity : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var down_to_up: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart=findViewById(R.id.btn_start)
        down_to_up=AnimationUtils.loadAnimation(this,R.anim.downtoup)
        btnStart!!.animation=down_to_up

       /*Handler().postDelayed({
           var mainIntent :Intent = Intent(this,SignUpActivity::class.java)
           startActivity(mainIntent)
       },3000)*/

        btnStart.setOnClickListener {
            var intent :Intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}


