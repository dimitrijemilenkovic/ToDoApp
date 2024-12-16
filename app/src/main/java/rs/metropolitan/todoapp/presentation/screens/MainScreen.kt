package rs.metropolitan.todoapp.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rs.metropolitan.todoapp.data.TaskDummyData
import rs.metropolitan.todoapp.domain.model.Task


@Composable
fun MainScreen(
    tasks:List<Task>,
    onDeleteTask: () -> Unit,
    onAddTask:()->Unit
    ){
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){


    }

}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen(tasks= TaskDummyData().loadDummyNotes(), onDeleteTask = {}, onAddTask = {})
}