package com.pjurado.ejercicio0608

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.pjurado.ejercicio0608.databinding.FragmentListaBinding


class ListaFragment : Fragment(R.layout.fragment_lista) {
    private lateinit var binding: FragmentListaBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListaBinding.bind(view).apply {
            recyclerView.adapter = TareasAdapter(TaskManager.tareas, this@ListaFragment){ tarea ->
                findNavController().navigate(R.id.action_listaFragment_to_detalleFragment,
                    bundleOf("tarea" to tarea)
                )

            }
        }
    }

    fun onBorrar(posicion: Int) {
        TaskManager.deleteTask(posicion)
        binding.recyclerView.adapter?.notifyItemRemoved(posicion)
    }

    fun onModificar(posicion: Int) {
        //findNavController().navigate(R.id.action_listaFragment_to_detalleFragment)
        //TaskManager.modifyTask(posicion, "Tarea modificada")
    }

    //private var tareas = listOf<String>("Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6", "Tarea 7", "Tarea 8", "Tarea 9", "Tarea 10")
}