import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun magicButton(
    initialVisibilityList: List<Boolean>,
    onToggle: (List<Boolean>) -> Unit,
    onSave: (List<Boolean>) -> Unit // Save function
) {
    var visibilityList by remember { mutableStateOf(initialVisibilityList) }

    Column {
        repeat(visibilityList.size) { index ->
            Row {
                Button(
                    onClick = {
                        visibilityList = visibilityList.toMutableList().apply {
                            this[index] = !this[index]
                        }
                        onToggle(visibilityList) // Update both button and visibility state
                        onSave(visibilityList) // Save the updated state when the button is clicked
                    }
                ) {
                    Text(text = if (visibilityList[index]) "ON" else "OFF")
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}