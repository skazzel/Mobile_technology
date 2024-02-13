package com.example.importanttodos

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.importanttodos.R
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.importanttodos.databinding.TodoItemBinding

class TodoItemAdapter(private val clickListener: (todoId: Long)->Unit): RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder>() {
    var data = listOf<Todo>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder = TodoItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, clickListener)
    }

    class TodoItemViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun inflateFrom(parent: ViewGroup) : TodoItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TodoItemBinding.inflate(layoutInflater, parent, false)
                return TodoItemViewHolder(binding)
            }
        }

        fun bind(item: Todo, clickListener: (todoId: Long) -> Unit) {
            binding.todo = item
            binding.root.setOnClickListener{clickListener(item.id)}
        }
    }
}