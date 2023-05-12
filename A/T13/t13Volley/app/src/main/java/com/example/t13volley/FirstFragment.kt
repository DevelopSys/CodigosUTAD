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
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t13volley.adapter.LigasAdapter
import com.example.t13volley.databinding.FragmentFirstBinding
import org.json.JSONArray

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var ligasAdapter: LigasAdapter;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ligasAdapter = LigasAdapter();
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

        binding.recyclerLigas.adapter = ligasAdapter;
        binding.recyclerLigas.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);


        val url = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php"
        var peticion: JsonObjectRequest =
            JsonObjectRequest(Request.Method.GET, url, null, {
                val arrayLigas: JSONArray = it.getJSONArray("leagues")

                for (i in 0 until arrayLigas.length()) {
                    val liga = arrayLigas.getJSONObject(i)
                    if (liga.getString("strSport") == "Soccer") {
                        //Log.v("respuesta", arrayLigas.getJSONObject(i).toString())
                        ligasAdapter.addLiga(liga.getString("strLeague"))
                    }
                }

            }, {
                Log.v("respuesta", "Error en la peticion")
            })

        Volley.newRequestQueue(context).add(peticion)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}