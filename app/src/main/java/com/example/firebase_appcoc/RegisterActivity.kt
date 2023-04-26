package com.example.firebase_appcoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {


    lateinit var TXT_name:EditText
    lateinit var TXT_email:EditText
    lateinit var TXT_pass:EditText
    lateinit var BTN_Create:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        TXT_name = findViewById(R.id.textname)
        TXT_email = findViewById(R.id.textemail)
        TXT_pass = findViewById(R.id.textpass)
        BTN_Create = findViewById(R.id.btncreate)

        BTN_Create.setOnClickListener {

        }

    }
}