package com.example.a7lahaly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a7lahaly.api.RetrofitClient
import com.example.a7lahaly.model.User
import com.example.a7lahaly.model.UserResponse
import com.example.a7lahaly.signUp.SignUpViewModel
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {

    lateinit var spinner :Spinner
    lateinit var login_forward : MaterialTextView
    lateinit var spin_val :String
    lateinit var viewModel :SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        spinner=findViewById(R.id.spinner_view)
        login_forward=findViewById(R.id.have_account_txt)
        setSimpleSpinner()

        login_forward.setOnClickListener(View.OnClickListener {
            var intent : Intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        })

        initViewModel()

        sign_up_btn.setOnClickListener {
            val name = name_edit_txt.text.toString().trim()
            val email = email_edit_txt.text.toString().trim()
            val phone = phone_edit_txt.text.toString().trim()
            val spinner_value=spin_val.trim()
            val field =field_edit_txt.text.toString().trim()
            val level=level_edit_txt.text.toString().trim()
            val password = password_edit_txt.text.toString().trim()

            val user  = User(name,"25",email,phone,password,1,1,
            field,level)
            viewModel.createNewUser(user)

            if(name.isEmpty()){
                name_edit_txt.error = "Name required"
                name_edit_txt.requestFocus()
                return@setOnClickListener
            }

            if(email.isEmpty()){
                email_edit_txt.error = "Email required"
                email_edit_txt.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                password_edit_txt.error = "Password required"
                password_edit_txt.requestFocus()
                return@setOnClickListener
            }



            if(phone.isEmpty()){
                phone_edit_txt.error = "School required"
                phone_edit_txt.requestFocus()
                return@setOnClickListener
            }

            //RetrofitClient.instance.createUser(1,name,"",email,phone,password,"","","",
            //spinner_value,field,level,0,0,0)


        }

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
                spin_val= parent!!.getItemAtPosition(pos).toString()
                if (parent!!.getItemAtPosition(pos).equals("Choose your faculty"))
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


    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <UserResponse?>{
            if(it  == null) {
                Toast.makeText(this@SignUpActivity, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@SignUpActivity, "Successfully created User", Toast.LENGTH_LONG).show()
            }
        })
    }



}