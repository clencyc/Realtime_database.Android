package com.example.firebase_appcoc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var EDTCar_make:EditText
    lateinit var EDTCAR_model:EditText
    lateinit var EDTCar_price:EditText
    lateinit var BTN_Carphoto:Button
    lateinit var BTN_cardata:Button
    lateinit var BTNView_data:Button

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EDTCar_make = findViewById(R.id.edtcarmake)
        EDTCAR_model = findViewById(R.id.edtcarmodel)
        EDTCar_price = findViewById(R.id.edtCarprice)
        BTN_Carphoto = findViewById(R.id.btnview_cars)
        BTN_cardata = findViewById(R.id.btncardata)
        BTNView_data = findViewById(R.id.btnview_cars)

        val database = FirebaseDatabase.getInstance()
        val databaseRef = database.getReference("cars")


        BTNView_data.setOnClickListener {

            var viewcars = Intent(this, ViewCarsActivity::class.java)


        }

        BTN_Carphoto.setOnClickListener {

        }

        BTN_cardata.setOnClickListener {

            val carmake = EDTCar_make.text.toString().trim()
            val carmodel = EDTCAR_model.text.toString().trim()
            val carprice = EDTCar_price.text.toString().trim()

            var id = System.currentTimeMillis().toString()

            var ref = database.getReference("cars/"+id)

            //validation
            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()){
                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            } else {

                //try to upload data to firebase
                val usercar = Cars(carmake,carmodel,carprice,id)
                //create a reference to firebaseDatabase

                val ref = FirebaseDatabase.getInstance().getReference().child("cars")


                ref.setValue(usercar).addOnCompleteListener{

                    if (it.isSuccessful){
                        Toast.makeText(this,"Car Data Uploaded Successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Failed tO Save Car Info",
                            Toast.LENGTH_LONG).show()
                    }

                }


            }


        }

    }
}
