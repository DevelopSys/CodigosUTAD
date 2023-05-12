package com.example.t13volley

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t13volley.adapter.TemporadasAdapter
import com.example.t13volley.databinding.FragmentSecondBinding
import com.example.t13volley.model.Liga

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var temporadasAdapter: TemporadasAdapter
    private lateinit var idLiga: String;
    private lateinit var url: String;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        temporadasAdapter = TemporadasAdapter();
        idLiga = arguments?.getString("id") ?: "00";
        url = "https://www.thesportsdb.com/api/v1/json/3/search_all_seasons.php?id="+idLiga
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerTemporadas.adapter = temporadasAdapter;
        binding.recyclerTemporadas.layoutManager = GridLayoutManager(context, 2);

        val peticionJSON: JsonObjectRequest =
            JsonObjectRequest(url, {
                val arrayTemporadas = it.getJSONArray("seasons")

                for (i in 0 until arrayTemporadas.length()) {
                    val temporada = arrayTemporadas.getJSONObject(i)
                    temporadasAdapter.addTemporada(temporada.getString("strSeason"))
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