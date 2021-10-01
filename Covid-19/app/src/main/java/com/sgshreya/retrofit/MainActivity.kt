package com.sgshreya.retrofit

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

const val BASE_URL="https://api.covid19api.com/"
class MainActivity : AppCompatActivity() {
    private var TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.welcome)
        val shader = LinearGradient(0f, 0f, 0f, textView.textSize, Color.RED, Color.WHITE, Shader.TileMode.CLAMP)
        textView.paint.shader = shader
        getCurrentData()
        button.setOnClickListener{
            getCurrentData()
        }
    }

    private fun getCurrentData(){
        newconfirmed.visibility = View.GONE
        totalconfirmed.visibility = View.GONE
        newdeaths.visibility = View.GONE
        totaldeaths.visibility = View.GONE
        newrecovered.visibility = View.GONE
        totalrecovered.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        val api=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequests::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getFacts().awaitResponse()
                if (response.isSuccessful) {
                    val data = response.body()!!
                    Log.d(TAG, data.Message)

                    withContext(Dispatchers.Main) {
                        newconfirmed.visibility = View.VISIBLE
                        totalconfirmed.visibility = View.VISIBLE
                        newdeaths.visibility = View.VISIBLE
                        totaldeaths.visibility = View.VISIBLE
                        newrecovered.visibility = View.VISIBLE
                        totalrecovered.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE

                        newconfirmed.text = "New Confirmed : " + data.Global.NewConfirmed.toString()
                        totalconfirmed.text =
                            "Total Confirmed : " + data.Global.TotalConfirmed.toString()
                        newdeaths.text = "New Deaths : " + data.Global.NewDeaths.toString()
                        totaldeaths.text = "Total Deaths : " + data.Global.TotalDeaths.toString()
                        newrecovered.text = "New Recovered : " + data.Global.NewRecovered.toString()
                        totalrecovered.text =
                            "Total Recovered : " + data.Global.TotalRecovered.toString()
                        updatedAt.text=data.Date
                    }
                }
            }
            catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}