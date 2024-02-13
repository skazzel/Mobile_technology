package com.example.importanttodos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TodosViewModelFactory(private val tq: TodosQueries): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TodosQueries::class.java).newInstance(tq)
    }
}