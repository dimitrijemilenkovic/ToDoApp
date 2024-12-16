package rs.metropolitan.todoapp.presentation.intent

import android.app.ActivityManager.TaskDescription

sealed class TaskIntent {
    object LoadTasks : TaskIntent()

    data class AddTask(
        val title: String,
        val description: String
    ) : TaskIntent()

    data class CheckTaskCompletion(val id:String):TaskIntent()

    data class DeleteTask(val id:String):TaskIntent()



}