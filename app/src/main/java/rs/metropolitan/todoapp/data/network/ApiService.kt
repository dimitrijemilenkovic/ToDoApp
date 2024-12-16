package rs.metropolitan.todoapp.data.network

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import rs.metropolitan.todoapp.domain.model.Task

interface ApiService{
    @GET(value = "tasks")
    suspend fun getAllTasks():List<Task>

    @POST(value = "tasks")
    suspend fun addTask(@Body task: Task)

    @DELETE(value = "tasks/{id}")
    suspend fun deleteTask(@Path("id") id:String)

    @PUT(value = "tasks/{id}")
    suspend fun checkedTaskCompletion(@Path("id") id:String ,@Body task:Task)

}