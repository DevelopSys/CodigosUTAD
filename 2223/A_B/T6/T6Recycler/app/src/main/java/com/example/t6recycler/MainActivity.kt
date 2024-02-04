package com.example.t6recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.t6recycler.adapter.AdaptadorJuegos
import com.example.t6recycler.databinding.ActivityMainBinding
import com.example.t6recycler.model.Juego

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaJuegos: ArrayList<Juego>
    private lateinit var adaptadorJuegos: AdaptadorJuegos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rellenarDatos()
        renderizarRecycler()

        // Spinner = datos (ArrayList -> ArrayAdapter -> BaseAdapter)
        // RecyclerView = datos (ArrayList -> RecyclerView.Adapter<ViewHolder> + XML)
        // RecyclerView -> Layout (linear, grid, staggered)

    }

    fun rellenarDatos(){
        listaJuegos = ArrayList()
        listaJuegos.add(Juego("GT7","Sony",2022,"Coches","http://cdn.shopify.com/s/files/1/1170/5330/products/PS4GranTurismo7_1024x1024.jpg?v=1646821787"))
        listaJuegos.add(Juego("RE8","Compañía",2021,"Terror","https://upload.wikimedia.org/wikipedia/en/f/fd/Resident_Evil_7_cover_art.jpg"))
        listaJuegos.add(Juego("GOW","Sony",2019,"Plataformas","https://upload.wikimedia.org/wikipedia/en/a/a7/God_of_War_4_cover.jpg"))
        listaJuegos.add(Juego("RED Redemptin","Compañia2",2022,"Plataformas",""))
        listaJuegos.add(Juego("Fifa","EA",2023,"Futbol","https://s1.gaming-cdn.com/images/products/5679/orig-fallback-v1/red-dead-redemption-2-pc-juego-rockstar-cover.jpg?v=1647026658"))
        listaJuegos.add(Juego("Pro Evolution","Sony",2019,"Futbol","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dailystar.co.uk%2Fsport%2Ffootball%2Fpro-evolution-soccer-front-covers-25109281&psig=AOvVaw3W9ehZ_3RaZt5uoCiapDgN&ust=1678793249921000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCOC9uazm2P0CFQAAAAAdAAAAABAE"))
        listaJuegos.add(Juego("Last of Us","Sony",2018,"Mundo abierto","https://static.wikia.nocookie.net/thelastofus/images/f/f7/TLOUPartIICoverArt.png/revision/latest?cb=20200207025050"))
        listaJuegos.add(Juego("GTAV","Sony",2017,"Mundo abierto","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc5dVoE8WSo-3y8AarodrFz2UQ5bl3BOw_zK0KZrgfQYF0gW8gNRk1JtIL_0LMU3y0X3U&usqp=CAU"))
    }
    fun renderizarRecycler(){
        adaptadorJuegos = AdaptadorJuegos(listaJuegos, applicationContext)
        binding.recyclerJuegos.adapter = adaptadorJuegos
        binding.recyclerJuegos.layoutManager = LinearLayoutManager(applicationContext
            ,LinearLayoutManager.VERTICAL,false)

        //binding.recyclerJuegos.layoutManager = GridLayoutManager(applicationContext,2)
        //binding.recyclerJuegos.layoutManager = StaggeredGridLayoutManager(applicationContext, StaggeredGridLayoutManager.VERTICAL)


    }
}
