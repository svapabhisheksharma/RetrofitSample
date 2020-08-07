 package com.example.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitsample.api.NetworkService
import com.example.retrofitsample.helpers.ServiceBuilder
import com.example.retrofitsample.models.RandomResult
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

 class MainActivity : AppCompatActivity() {
     var tv1:String?="null"
     var tv2:String?="null"
     var tv3:String?="null"
     var tv4:String?="null"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.send)

        button.setOnClickListener {
            sendRequest()
        }


    }

     private fun sendRequest(){

         val request = ServiceBuilder().buildService(NetworkService::class.java)
         val call = request.getValues()

         val textview1 =findViewById<TextView>(R.id.textView1)
         val textview2 =findViewById<TextView>(R.id.textView2)
         val textview3 =findViewById<TextView>(R.id.textView3)
         val textview4 =findViewById<TextView>(R.id.textView4)

         call.enqueue(object:Callback<RandomResult>{
             override fun onResponse(call: Call<RandomResult>, response: Response<RandomResult>){

                if (response.code()==200){
                    val response = response.body()

                    tv1 = response!!.id
                    tv2 = response!!.language
                    tv3 = response!!.source
                    tv4 = response!!.text

                    textview1.text = tv1
                    textview2.text = tv2
                    textview3.text = tv3
                    textview4.text = tv4

                }

             }

             override fun onFailure(call: Call<RandomResult>, t: Throwable) {
                 Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()

             }
         })

     }

}