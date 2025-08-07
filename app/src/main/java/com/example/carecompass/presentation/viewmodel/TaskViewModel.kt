package com.example.carecompass.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.carecompass.domain.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TasksViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private var taskIdCounter = 1

    fun addTask(title: String, description: String) {
        val newTask = Task(taskIdCounter++, title, description)
        _tasks.value = _tasks.value + newTask
    }

    fun deleteTask(taskId: Int) {
        _tasks.value = _tasks.value.filter { it.id != taskId }
    }
}
