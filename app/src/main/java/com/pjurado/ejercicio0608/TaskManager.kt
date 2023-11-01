package com.pjurado.ejercicio0608

class TaskManager {
    companion object{
        val tareas = mutableListOf<String>("Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6", "Tarea 7", "Tarea 8", "Tarea 9", "Tarea 10")
        fun addTask(task: String){
            tareas.add(task)
        }
        fun deleteTask(position: Int){
            tareas.removeAt(position)
        }
        fun modifyTask(position: Int, task: String){
            tareas[position] = task
        }

    }
}