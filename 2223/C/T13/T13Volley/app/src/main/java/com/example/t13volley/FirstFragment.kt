package com.example.t13volley

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t13volley.adapter.LigasAdapter
import com.example.t13volley.databinding.FragmentFirstBinding
import com.example.t13volley.model.Liga
import org.json.JSONObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var ligasAdapter: LigasAdapter;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ligasAdapter = LigasAdapter(this);

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerLigas.adapter = ligasAdapter
        binding.recyclerLigas.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // 1- crear la peticion
        val url = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php"
        val peticionJSON: JsonObjectRequest =
            JsonObjectRequest(url, {
                val arrayLigas = it.getJSONArray("leagues")

                for (i in 0 until arrayLigas.length()) {
                    val liga = arrayLigas.getJSONObject(i)
                    if (liga.getString("strSport") == "Soccer") {
                        val objLiga = Liga(
                            liga.getString("idLeague"),
                            liga.getString("strLeague"),
                            liga.getString("strSport"),
                            liga.getString("strLeagueAlternate")
                        )
                        ligasAdapter.addLiga(objLiga)
                    }

                }


            }, {
                Log.v("respuesta", "Error en la conexion")
            })

        // 2- consumirla
        Volley.newRequestQueue(context).add(peticionJSON)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}