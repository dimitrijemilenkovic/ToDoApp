package rs.metropolitan.todoapp.presentation.state

import rs.metropolitan.todoapp.domain.model.Task

data class TaskState (
    val tasks: List<Task> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)