package rs.metropolitan.todoapp.data

import rs.metropolitan.todoapp.domain.model.Task

class TaskDummyData {
    fun loadDummyNotes() : List<Task>{
        return listOf(
            Task("Clean room", "Tidy up by 11 am", false),
            Task("Finish report", "Submit report by 5 pm", true),
            Task("Buy groceries", "Get essentials from the store", false),
            Task("Water plants", "Water indoor plants at 8 am", true),
            Task("Pay bills", "Electricity and internet bills by 3 pm", false),
            Task("Call mom", "Catch up with mom after lunch", true),
            Task("Exercise", "30-minute workout at 7 am", false),
            Task("Read book", "Read 20 pages before bed", true),
            Task("Prepare dinner", "Cook pasta at 7 pm", false),
            Task("Plan trip", "Research destinations for vacation", true)
        )

    }
}