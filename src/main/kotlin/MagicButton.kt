import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/////////////////////////////////////////////////////////////////////////////////////////////////////// Hide/Show Button
@Composable
fun buttonToToggleVisibility(onToggle: (List<Boolean>) -> Unit) {
    Button(
        onClick = {
/////////////////////////////////////////////////////////////////////////////////// Toggles visibility for the first box
            val updatedVisibility = listOf(false, true, true, true) // Update this as needed
            onToggle(updatedVisibility)
        }
    ) {
        Text(text = "Toggle Box 1")
    }
}