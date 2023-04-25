package com.example.firebase_appcoc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var EDTxt:EditText
    lateinit var BTNSave_data:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EDTxt = findViewById(R.id.edtname)
        BTNSave_data = findViewById(R.id.btnsave)

        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference


        BTNSave_data.setOnClickListener {

            var user_data = EDTxt.text.toString().trim()

            databaseRef.setValue(user_data)


           // Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
        }

    }
}