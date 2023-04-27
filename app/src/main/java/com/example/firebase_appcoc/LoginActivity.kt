package com.example.firebase_appcoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var EDTemail:EditText
    lateinit var EDT_pass:EditText
    lateinit var BTN_Log_in:Button
    lateinit var BTN_register:Button

    lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EDTemail = findViewById(R.id.edtemail)
        EDT_pass = findViewById(R.id.edtpassword)
        BTN_Log_in = findViewById(R.id.btnlogin)
        BTN_register = findViewById(R.id.btnregister)

        auth = FirebaseAuth.getInstance()


        BTN_register.setOnClickListener {
            //navigate user to registration page
            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)

        }

        BTN_Log_in.setOnClickListener {

            var email = EDTemail.text.toString().trim()
            var pass = EDT_pass.text.toString().trim()

            //validate
            if (email.isEmpty() || pass.isEmpty()){

                Toast.makeText(this, "Cannot Submit an Empty field", Toast.LENGTH_SHORT).show()

            } else {
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this){

                    if (it.isSuccessful){
                        Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show()

                        //
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()

                    }else {

                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
                }


        }
    }
}