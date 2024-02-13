package com.example.importanttodos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditTodoViewModelFactory(private val todoId: Long, private val tq: TodosQueries): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Long::class.java, TodosQueries::class.java).newInstance(todoId, tq)
    }
}