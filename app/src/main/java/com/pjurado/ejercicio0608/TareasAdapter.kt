package com.pjurado.ejercicio0608

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pjurado.ejercicio0608.databinding.ViewTareaBinding

class TareasAdapter(
    val tareas: List<String>,
    val context: ListaFragment,
    val listener: (String) -> Unit)
    : RecyclerView.Adapter<TareasAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ViewTareaBinding.bind(view)

        fun bind(tarea: String){
            binding.nombre.text = tarea
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_tarea, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = tareas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tareas[position])
        holder.binding.nombre.setOnClickListener { listener(tareas[position]) }
        holder.binding.btnBorrar.setOnClickListener { context.onBorrar(position)}
        holder.binding.btnModificar.setOnClickListener { context.onModificar(position) }
    }

}
