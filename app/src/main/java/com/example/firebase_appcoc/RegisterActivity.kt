package com.example.firebase_appcoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {


    lateinit var TXT_name:EditText
    lateinit var TXT_email:EditText
    lateinit var TXT_pass:EditText
    lateinit var BTN_Create:Button
    //initialize firebase
    lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        TXT_name = findViewById(R.id.textname)
        TXT_email = findViewById(R.id.textemail)
        TXT_pass = findViewById(R.id.textpass)
        BTN_Create = findViewById(R.id.btncreate)
        //calling the auth instance
        auth = FirebaseAuth.getInstance()

        BTN_Create.setOnClickListener {
            //taking user info
            var name = TXT_name.text.toString().trim()
            var email = TXT_email.text.toString().trim()
            var password = TXT_pass.text.toString().trim()

            //validate user info
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "Cannot Submit an Empty field", Toast.LENGTH_SHORT).show()

            } else {

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){

                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                        //navigate back to login
                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)

                    } else{
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                    }
                }
            }



        }

    }
}