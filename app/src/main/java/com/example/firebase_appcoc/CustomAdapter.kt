package com.example.firebase_appcoc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class CustomAdapter(var context: Context, var data:ArrayList<Cars>):BaseAdapter() {
    private class ViewHolder(row:View?){


        //step 1 declare your textviews
        var txtcarmake:TextView
        var txtcarmodel:TextView
        var txtcarprice:TextView
        var btn_update:Button
        var btn_delete:Button

        init {

            //step 2 find views by ID
            this.txtcarmake = row?.findViewById(R.id.mTvCarMake) as TextView
            this.txtcarmodel = row?.findViewById(R.id.mTvCarModel) as TextView
            this.txtcarprice = row?.findViewById(R.id.mTvCarPrice) as TextView
            this.btn_update = row?.findViewById(R.id.btnUpdate) as Button
            this.btn_delete = row?.findViewById(R.id.btnDelete) as Button

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.cars_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Cars = getItem(position) as Cars
        viewHolder.txtcarmake.text = item.carmake  //coming from your model
        viewHolder.txtcarmodel.text = item.carmodel
        viewHolder.txtcarprice.text = item.carprice

        viewHolder.btn_update.setOnClickListener {

            //grab data and pass as PutEXTRA
            // var intent = Intent(context, UpdateCar_Record::class.java)

            //intent.putExtra("car_make", item.car_make)
            // intent.putExtra("car_model", item.car_model)
            // intent.putExtra("car_price", item.car_price)
            //intent.putExtra("car_id", item.car_id)

            //context.startActivity(intent)


            // var ref = FirebaseDatabase.getInstance().getReference().child("cars/"+item.car_id)

        }

        viewHolder.btn_delete.setOnClickListener {

            // var ref = FirebaseDatabase.getInstance().getReference().child("cars/"+item.car_id)

            //toast a message to delete item
            // ref.removeValue().addOnCompleteListener {
            //if (it.isSuccessful) {

            //  Toast.makeText(context, "Item has been Deleted", Toast.LENGTH_SHORT).show()
            //  } else {
            //  Toast.makeText(context, "Failed to delete item", Toast.LENGTH_SHORT).show()
            //  }

            //}

        }


        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}