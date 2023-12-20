import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun secondScreen(onToggleMainScreen: (List<Boolean>) -> Unit) {
    buttonToToggleVisibility {
        onToggleMainScreen(it)
    }
}


