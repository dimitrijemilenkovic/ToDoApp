package rs.metropolitan.todoapp.presentation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import rs.metropolitan.todoapp.data.TaskDummyData
import rs.metropolitan.todoapp.data.network.ApiService
import rs.metropolitan.todoapp.data.repository.TaskRepository
import rs.metropolitan.todoapp.presentation.screens.MainScreen
import rs.metropolitan.todoapp.presentation.ui.theme.ToDoAppTheme
import rs.metropolitan.todoapp.presentation.viewmodels.TaskViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()

                }
            }
        }
    }
}

