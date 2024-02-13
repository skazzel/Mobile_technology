package com.example.importanttodos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodosDatabase : RoomDatabase() {
    abstract val todosQueries: TodosQueries

    companion object {
        @Volatile
        private var INSTANCE: TodosDatabase? = null

        // create instance of database
        fun getInstance(context: Context): TodosDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, TodosDatabase::class.java, "todo_database").build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}