package rs.metropolitan.todoapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.metropolitan.todoapp.presentation.util.Colors

@Composable
fun InputTask(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    leadingIcon: ImageVector,
    iconDescription: String,
    onTextChange: (String) -> Unit,
    placeHolderText: String,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            .fillMaxWidth(),
        value = value,
        onValueChange = onTextChange,
        label = {
            Text(label)
        },
        placeholder = { Text(placeHolderText) },
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = iconDescription) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            unfocusedLabelColor = Colors.mPrimaryColor,
            unfocusedLeadingIconColor = Colors.mPrimaryColor,
            unfocusedIndicatorColor = Colors.mPrimaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        })


    )

}

@Preview
@Composable
fun ITPreview() {
    InputTask(
        label = "Unesi Task",
        leadingIcon = Icons.Default.Email,
        placeHolderText = "UnesiTask",
        iconDescription = "Icon",
        onTextChange = {},
        value = ""
    )
}


