package rs.metropolitan.todoapp.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.metropolitan.todoapp.domain.model.Task
import rs.metropolitan.todoapp.presentation.util.Colors

@Composable
fun TaskRow(
    task: Task,
    onCheckBoxClick: () -> Unit,
    onDelete: () -> Unit

) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth(),
        color = Colors.mRowColor,
        shadowElevation = 5.dp

    ) {
        Row(
            modifier = Modifier
                .padding(7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Column {
                Text(text = task.title)
                Text(text = task.description)
            }
            Row(


            ) {
                Checkbox(

                    checked = task.isChecked,
                    onCheckedChange = {isChecked ->
                        onCheckBoxClick()
                        Log.d("greska","Kliknuto")
                                      },
                    modifier = Modifier
                        .padding(end = 15.dp),
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Colors.mPrimaryColor,
                        checkedColor = Colors.mPrimaryColor
                    )
                )
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "Hay",
                    modifier = Modifier.clickable {
                        Log.d("greska","Kliknuto")
                        onDelete() },
                    tint = Color(0xFFB34242)
                )
            }


        }


    }


}

