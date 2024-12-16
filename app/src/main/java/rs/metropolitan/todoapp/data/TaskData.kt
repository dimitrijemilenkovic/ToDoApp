package rs.metropolitan.todoapp.data

import rs.metropolitan.todoapp.domain.model.Task

class TaskDummyData {
    fun loadDummyNotes() : List<Task>{
        return listOf(
            Task("1","Clean room", "Tidy up by 11 am", false)
        )

    }
}