package rs.metropolitan.todoapp.data.network

import retrofit2.http.GET
import rs.metropolitan.todoapp.domain.model.Task

interface TaskApi{
    @GET(value = "tasks")
    suspend fun getAllTasks():List<Task>


}