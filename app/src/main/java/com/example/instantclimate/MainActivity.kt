package com.example.instantclimate

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    var tvCity: TextView? = null
    var tvDegree: TextView? = null
    var tvWeather: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCity = findViewById(R.id.tvCity)
        tvDegree = findViewById(R.id.tvDegree)
        tvWeather = findViewById(R.id.tvWeather)

        val city =
            intent.getStringExtra("com.example.instantclimate.cities.CITY") //Obtengo del intent el String pasado por parámetro

        if (Network.existsNetwork(this)) {
            requestHttpVolley("https://api.openweathermap.org/data/2.5/weather" +
                                "?id="+ city +
                                "&&appid=d22ad76caeca455fc55e122b59ca5a0c" +
                                "&units=metric")
        } else {
            Toast.makeText(this, "You not have network", Toast.LENGTH_SHORT).show()
        }

    }

    @SuppressLint("SetTextI18n")
    fun setDataCity(city: City) {
        tvCity?.text = city.name
        tvDegree?.text = city.main?.temp.toString() + "°"
        tvWeather?.text = city.weather?.get(0)?.description
    }

    //Método para volley
    //Funciona a través de una estructura de cola. Empieza a recibir solicitudes y las va despachando conforme llega
    private fun requestHttpVolley(url: String) {
        val queue = Volley.newRequestQueue(this) //Genera la nueva cola
        var request = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            try {
                //Operaciones necesarias para poder procesar la solicitud
                Log.d("Request: ", response)
                val gson = Gson()
                val city = gson.fromJson(response, City::class.java)
                setDataCity(city)

            } catch (e: Exception) {

            }
        }, Response.ErrorListener { }) //Resultado en forma de String

        queue.add(request)
    }
}
