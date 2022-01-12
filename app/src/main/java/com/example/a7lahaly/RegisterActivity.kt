package com.example.a7lahaly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class RegisterActivity : AppCompatActivity() {
    lateinit var signup_forward : MaterialTextView
    lateinit var forget_pass : MaterialTextView
    lateinit var sign_in_btn : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signup_forward=findViewById(R.id.create_account_txt)
        forget_pass=findViewById(R.id.forget_password_txt)
        sign_in_btn=findViewById(R.id.sign_in_btn)

        signup_forward.setOnClickListener(View.OnClickListener {
            var intent : Intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        })

        forget_pass.setOnClickListener(View.OnClickListener {
            var intent : Intent = Intent(this,ChangePasswordActivity::class.java)
            startActivity(intent)
        })

        sign_in_btn.setOnClickListener(View.OnClickListener {
            var homeIntent : Intent = Intent(this,HomeeActivity::class.java)
            startActivity(homeIntent)
        })

    }
}