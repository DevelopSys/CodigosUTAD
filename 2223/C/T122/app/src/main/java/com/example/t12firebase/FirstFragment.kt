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
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()

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
        //auth.signOut()
        binding.botonSigUp.setOnClickListener {
            auth.createUserWithEmailAndPassword(binding.editUsername.text.toString(),
                binding.editPassword.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Snackbar.make(binding.root,"Registro correcto",Snackbar.LENGTH_SHORT).show()
                    } else {
                        Snackbar.make(binding.root,"Algo ha fallado",Snackbar.LENGTH_SHORT).show()
                    }
                }
            // registro ok -> no esta el usuario creado,la pass es correcta, la conexion es correcta
            // registro fallo -> si ya hay un usuario, si la pass es mala, si el correo no esta bien formateado
        }
        binding.botonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.editUsername.text.toString(),
                binding.editPassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        val bundle = Bundle()
                        bundle.putString("uid",auth.uid!!)
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
                    } else {
                        Snackbar.make(binding.root,"Datos incorrectos",Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}