package com.pjurado.ejercicio0608

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjurado.ejercicio0608.databinding.FragmentDetalleBinding

class DetalleFragment : Fragment(R.layout.fragment_detalle) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetalleBinding.bind(view).apply {
            val tarea = arguments?.getString("tarea")
            nombre.text = tarea
        }
    }
}