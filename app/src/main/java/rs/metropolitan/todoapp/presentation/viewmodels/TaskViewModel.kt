package rs.metropolitan.todoapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import rs.metropolitan.todoapp.data.repository.TaskRepository
import rs.metropolitan.todoapp.domain.model.Task
import rs.metropolitan.todoapp.presentation.intent.TaskIntent
import rs.metropolitan.todoapp.presentation.state.TaskState
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {
    private val _state = MutableStateFlow(TaskState())
    val state: StateFlow<TaskState> = _state

    init {
        Log.d("chcekGreska","inicijalizacija")
        loadTasks()
    }

    fun handleIntent(intent: TaskIntent) {
        when (intent) {
            is TaskIntent.LoadTasks -> loadTasks()
            is TaskIntent.AddTask -> addTask(intent.title, intent.description)
            is TaskIntent.CheckTaskCompletion -> checkTaskCompletion(intent.id)
            is TaskIntent.DeleteTask -> deleteTask(intent.id)
        }
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val tasks = repository.getTasks()
                _state.value = TaskState(tasks = tasks, isLoading = false)
            } catch (e: Exception) {
                _state.value = TaskState(error = e.message, isLoading = false)
            }
        }
    }

    private fun addTask(title: String, description: String) {
        viewModelScope.launch {
            repository.addTask(
                Task(
                    id = (_state.value.tasks.size + 1).toString(),
                    title = title,
                    description = description,
                    isChecked = false
                )
            )
            loadTasks()

        }
    }

    private fun checkTaskCompletion(id: String) {
        viewModelScope.launch {
            Log.d("chcekGreska",id.toString())
            repository.checkTaskCompletion(id)
            loadTasks()
        }
    }

    private fun deleteTask(id: String) {
        viewModelScope.launch {
            Log.d("chcekGreska",id.toString())
            repository.deleteTask(id)
            loadTasks()
        }
    }
}