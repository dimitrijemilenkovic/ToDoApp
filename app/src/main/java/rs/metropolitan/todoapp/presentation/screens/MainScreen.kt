package rs.metropolitan.todoapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import rs.metropolitan.todoapp.data.TaskDummyData
import rs.metropolitan.todoapp.presentation.components.CustomButton
import rs.metropolitan.todoapp.presentation.components.InputTask
import rs.metropolitan.todoapp.presentation.components.TaskRow
import rs.metropolitan.todoapp.presentation.components.TodoTopAppBar
import rs.metropolitan.todoapp.presentation.intent.TaskIntent
import rs.metropolitan.todoapp.presentation.viewmodels.TaskViewModel


@Composable
fun MainScreen(
    viewModel: TaskViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            topBar = { TodoTopAppBar(title = "ToDo", onClick = {}) },
            floatingActionButton = {
                CustomButton(onAdd = {
                    viewModel.handleIntent(
                        TaskIntent.AddTask(
                            title,
                            description
                        )
                    )
                    title = ""
                    description = ""
                })
            }
        ) { padding ->
            Column {
                Column(modifier = Modifier.padding(padding)) {
                    InputTask(
                        label = "Unesi Task",
                        value = title,
                        leadingIcon = Icons.Filled.Edit,
                        iconDescription = "Create Task",
                        onTextChange = { title = it },
                        placeHolderText = "Task Title"
                    )
                    InputTask(
                        label = "Unesi Opis",
                        value = description,
                        leadingIcon = Icons.Filled.Info,
                        iconDescription = "Create Task",
                        onTextChange = { description = it },
                        placeHolderText = "Task Description"
                    )

                }
                Divider(modifier = Modifier.padding(10.dp))
                if (state.isLoading) CircularProgressIndicator()
                LazyColumn {
                    items(
                        state.tasks
                    ) { task ->
                        TaskRow(
                            task = task,
                            onCheckBoxClick = {
                                Log.d("chcekGreska",task.title)
                                viewModel.handleIntent(
                                    TaskIntent.CheckTaskCompletion(task.id)
                                )
                            },
                            onDelete = {
                                Log.d("greska","Deletnuto")
                                viewModel.handleIntent(TaskIntent.DeleteTask(task.id))
                            })
                    }
                }

            }


        }


    }

}


