@file:OptIn(ExperimentalMaterial3Api::class)

package rs.metropolitan.todoapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import rs.metropolitan.todoapp.R
import rs.metropolitan.todoapp.R.string.topbar_str
import rs.metropolitan.todoapp.presentation.util.Colors


@Composable
fun TodoTopAppBar(
    modifier: Modifier = Modifier,
    title:String,
    onClick:()-> Unit
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = onClick
            ) { Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu Icon") }
        },
        title = {
            Text(text = title)
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Colors.mBackgroundColor)


    )

}
@Preview
@Composable
fun TopAppBarPreview(){
    TodoTopAppBar(title = stringResource(id= topbar_str), onClick = {})
}