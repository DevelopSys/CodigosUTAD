package com.example.t6recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6recycler.adapter.AdaptadorJuego
import com.example.t6recycler.databinding.ActivityMainBinding
import com.example.t6recycler.model.Juego

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaJuegos: ArrayList<Juego>
    private lateinit var adaptadorJuegos: AdaptadorJuego

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personalizarRecycler()

    }

    fun personalizarRecycler(){

        // recycler gráfico --> binding (OK)
        // datos --> clase (OK)--> lista (OK) (ArrayList<Juego> // SQLite // API)
        listaJuegos = ArrayList<Juego>()
        listaJuegos.add(Juego("GTAV","Mundo abierto",2017,"https://cdn.mobygames.com/covers/685125-grand-theft-auto-v-front-cover.jpg"))
        listaJuegos.add(Juego("GT7","Coches",2022,"https://i.redd.it/sw7dlla905s51.jpg"))
        listaJuegos.add(Juego("RE","Terror",2022,"https://static.wikia.nocookie.net/residentevil/images/7/7f/RE7_cover_ps4.jpg/revision/latest?cb=20190831041635"))
        listaJuegos.add(Juego("Fifa","Futbol",2022,"https://assets.reedpopcdn.com/fifa-main-2.png/BROK/resize/1200x1200%3E/format/jpg/quality/70/fifa-main-2.png"))
        listaJuegos.add(Juego("Pro","Futbol",2019,"https://i2-prod.dailystar.co.uk/incoming/article25110248.ece/ALTERNATES/s615b/0_JS246625829.jpg"))
        listaJuegos.add(Juego("GOW","Plataformas",2023,"https://www.codigi.es/wp-content/uploads/2022/02/god-of-war-pc-game-steam-cover-1.jpg"))
        listaJuegos.add(Juego("Forza","Coches",2020,"https://upload.wikimedia.org/wikipedia/en/8/87/Forza_Horizon_4_cover.jpg"))
        listaJuegos.add(Juego("Red Redenptipn","Mundo Abierto",2020,"https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/81YdZRdE1BL._AC_SL1500_.jpg"))

        // Adaptador (RecyclerView.Adapter<VH> + XML (OK) (aspecto de la fila) (OK)
        adaptadorJuegos = AdaptadorJuego(listaJuegos,applicationContext)

        binding.recyclerJuegos.adapter = adaptadorJuegos
        binding.recyclerJuegos.layoutManager =
            LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

    }
}