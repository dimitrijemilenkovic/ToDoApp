package rs.metropolitan.todoapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import rs.metropolitan.todoapp.presentation.util.Colors

@Composable
fun CustomButton(
    onAdd: ()-> Unit
){
    FloatingActionButton(
        onClick = onAdd,
        containerColor = Colors.mBackgroundButtonColor,
        contentColor = Colors.mSecondaryColor,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 5.dp, hoveredElevation = 7.dp)
    ) {
        Icon(Icons.Filled.Add,"Add Icon")
    }

}