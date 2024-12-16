package rs.metropolitan.todoapp.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id:String,
    val title:String,
    val description:String,
    val isChecked:Boolean
) {


}