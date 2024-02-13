package com.example.importanttodos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodosViewModel(val tq: TodosQueries): ViewModel() {
    var newTodoTitle = ""
    val todos = tq.getAll()
    private val _navigateToTodo = MutableLiveData<Long?>()
    val navigateToTodo: LiveData<Long?>get() = _navigateToTodo

    fun addTodo() {
        viewModelScope.launch {
            val todo = Todo()
            todo.title = newTodoTitle
            tq.insert(todo)
        }
    }

    fun onTodoItemClicked(todoId: Long) {
        _navigateToTodo.value = todoId
    }

    fun onTodoVavigated() {
        _navigateToTodo.value = null
    }
}