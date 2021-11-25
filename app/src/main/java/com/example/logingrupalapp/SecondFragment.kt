package com.example.logingrupalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.logingrupalapp.databinding.FragmentSecondBinding
import com.example.logingrupalapp.model.LoginGrupalApplication
import com.example.logingrupalapp.model.UsuarioEntidad
import com.example.logingrupalapp.util.StringUtils

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonVolver.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        iniciarCrearUsuario()

        // la 42 estaba en la 41, probando...
    }

    private fun iniciarCrearUsuario() {
        binding.btnCrearUsuarioRegistro.setOnClickListener {
            guardarRegistroUsuario()
        }
    }

    // PASO 2, ESTAMOS TRAYENDO LA INFO Y LA VAMOS A PONER CON EL METODO INSERTAR
    private fun guardarRegistroUsuario() {
        // PARTE 2 DEL PASO 2
        val correo = binding.edtCorreoRegistro.text.toString()
        val contraseña = binding.edtContraseniaRegistro.text.toString()

        if(!correo.isEmpty() && !contraseña.isEmpty()){
            if (StringUtils.validarCorreo(correo) && StringUtils.validarContraseña(contraseña)){
                //PASO 1, lo que venia del LOGINGRUPALAPPLICATION
                // crear un metodo para que no quede aca
                insertarRegistroDB(correo,contraseña)
                Toast.makeText(context,"Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Contraseña y correo no validos", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(context,"Contraseña y correo vacios", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertarRegistroDB(correo:String, contraseña:String) {
        val nuevoUsuarioEntidad = UsuarioEntidad(correo=correo,contraseña=contraseña)
        // Despues se lo paso al paso 1


        // PARTE 1 DEL PASO 2
        //ACA HAY QUE CREAR EL OBJETIO PARA QUE SE INSERTE
        LoginGrupalApplication.DATABASE.registroDao.insertAll(nuevoUsuarioEntidad)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}