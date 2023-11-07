package com.pjurado.ejercicio0608

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjurado.ejercicio0608.databinding.FragmentModificarBinding


class ModificarFragment : Fragment(R.layout.fragment_modificar) {

    companion object{
        const val POS = "posicion"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentModificarBinding.bind(view).apply {
            val posicion = arguments?.getInt(POS)
            if (posicion != -1) {
                nombre.setText(TaskManager.tareas[posicion!!])
            }

            btnGuardar.setOnClickListener {
                if (posicion != -1) {
                    TaskManager.modifyTask(posicion, nombre.text.toString())
                } else{
                    TaskManager.addTask(nombre.text.toString())
                }
                parentFragmentManager.popBackStack()
            }

            btnCancelar.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
    }
}