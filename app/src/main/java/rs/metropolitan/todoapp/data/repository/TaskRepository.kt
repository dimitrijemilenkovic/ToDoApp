package rs.metropolitan.todoapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log

import rs.metropolitan.todoapp.data.network.ApiService
import rs.metropolitan.todoapp.domain.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(private val api: ApiService) {
    suspend fun getTasks(): List<Task> {
        return try {
            api.getAllTasks()
        }catch (e:Exception){
            emptyList()
        }
    }

    suspend fun addTask(task: Task) {
        return api.addTask(task)
    }

    suspend fun checkTaskCompletion(id: String) {
        try {
            val task = api.getAllTasks().first { it.id == id }
            Log.d("chcekGreska",task.title)

            api.checkedTaskCompletion(id = id, task = task.copy(isChecked = !task.isChecked))
        }catch (e:Exception){
            Log.d(TAG, e.message.toString())
        }


    }

    suspend fun deleteTask(id: String) {
        return api.deleteTask(id)
    }

}