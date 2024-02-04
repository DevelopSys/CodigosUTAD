package com.example.peticionesjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php"
        var peticion: JsonObjectRequest = JsonObjectRequest(url, {

            val ligas = it.getJSONArray("leagues");

            for (i in 0 until ligas.length()) {
                val liga = ligas.getJSONObject(i);
                var nombre = liga.getString("strLeague")
                var deporte = liga.getString("strSport")
                var nombreALT = liga.getString("strLeagueAlternate");

                val ligaOBJ = Liga(nombre,deporte, nombreALT);
            }


        }, {
            //Snackbar.make(applicationContext,"Fallo en conexion", Snackbar.LENGTH_SHORT).show()
        })

        Volley.newRequestQueue(applicationContext).add(peticion);
    }
}