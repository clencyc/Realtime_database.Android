package com.example.firebase_appcoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var EDTemail:EditText
    lateinit var EDT_pass:EditText
    lateinit var BTN_Log_in:Button
    lateinit var BTN_register:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EDTemail = findViewById(R.id.edtemail)
        EDT_pass = findViewById(R.id.edtpassword)
        BTN_Log_in = findViewById(R.id.btnlogin)
        BTN_register = findViewById(R.id.btnregister)


        BTN_register.setOnClickListener {
            //navigate user to registration page
            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)

        }

        BTN_Log_in.setOnClickListener {
            //
        }
    }
}