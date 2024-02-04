package com.example.t12firebase

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t12firebase.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance();
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

        binding.botonSigin.setOnClickListener {
            // sacar lo que hay en los edit y registrar
            auth.createUserWithEmailAndPassword(
                binding.editUsername.text.toString(),
                binding.editPassword.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(
                            binding.root,
                            "Tarea completa con exito",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Tarea completa con fallo",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }


        }

        binding.botonLogin.setOnClickListener {
            // sacar lo que hay en los edit y pasar de fragment
            auth.signInWithEmailAndPassword(
                binding.editUsername.text.toString(),
                binding.editPassword.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        // pasar al otro fragment

                        val bundle = Bundle();
                        bundle.putString("uid", auth.currentUser!!.uid)

                        findNavController().navigate(
                            R.id.action_FirstFragment_to_SecondFragment,
                            bundle
                        )
                    } else {
                        Snackbar.make(binding.root, "Fallo en el login", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}