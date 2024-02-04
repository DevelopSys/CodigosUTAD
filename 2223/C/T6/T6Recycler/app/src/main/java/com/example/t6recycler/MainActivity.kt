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
    private lateinit var adaptadorJuego: AdaptadorJuego

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personalizarRecycer()
    }

    fun personalizarRecycer(){

        // gráfica -> binding (OK)
        // elementos -> Clase / Juego (OK) -> ArrayList / SQLite / API (OK)
        listaJuegos = ArrayList()
        listaJuegos.add(Juego("GTV","Mundo abierto","https://cdn.mobygames.com/covers/3482873-grand-theft-auto-v-front-cover.jpg",2017))
        listaJuegos.add(Juego("GT7","Coches","https://i.redd.it/sw7dlla905s51.jpg",2023))
        listaJuegos.add(Juego("Fifa","Fútbol","https://assets.reedpopcdn.com/fifa-main-2.png/BROK/resize/1200x1200%3E/format/jpg/quality/70/fifa-main-2.png",2023))
        listaJuegos.add(Juego("Pro Evolution","Fútbol","http://3.bp.blogspot.com/-uONC9G9H7FM/Tcmo_XrOP1I/AAAAAAAACaI/1gppgU7Et4A/s1600/proevo2009_wii.jpg",2017))
        listaJuegos.add(Juego("Forza","Coches","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.reddit.com%2Fr%2Fforza%2Fcomments%2F8q4swk%2Fforza_horizon_4_game_cover%2F&psig=AOvVaw2NScHo8o05xFsTsgWdqlaS&ust=1679138586762000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCJi25uns4v0CFQAAAAAdAAAAABAQ",2019))
        listaJuegos.add(Juego("Red Redeptinon","Mundo abierto","https://www.gtabase.com/igallery/4201-4300/RDR_2_Cover_PC-4213-1920.jpg",2020))
        listaJuegos.add(Juego("RE","Terror","https://cdn.cdkeys.com/700x700/media/catalog/product/r/e/resident_evil_village_pc_cover.jpg",2020))
        listaJuegos.add(Juego("Silent Hill","Terror","https://i1.sndcdn.com/artworks-8pIW1s0ylCzvBXt6-vHuhJA-t500x500.jpg",2021))
        listaJuegos.add(Juego("GOD","Plataformas","https://upload.wikimedia.org/wikipedia/en/e/ee/God_of_War_Ragnarök_cover.jpg",2023))
        listaJuegos.add(Juego("Prince of persia","Plataformas","https://upload.wikimedia.org/wikipedia/en/8/86/Sands_of_time_cover.jpg",2021))


        // adaptador -> RecyclerView.Adapter<VH> + XML (fila) (OK)
        adaptadorJuego = AdaptadorJuego(listaJuegos,applicationContext)

        binding.recyclerJuegos.adapter = adaptadorJuego
        binding.recyclerJuegos.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)
        /*binding.recyclerJuegos.layoutManager = GridLayoutManager(applicationContext,
            2)*/


    }
}