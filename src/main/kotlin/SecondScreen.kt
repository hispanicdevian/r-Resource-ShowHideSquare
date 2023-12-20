import androidx.compose.runtime.Composable

@Composable
fun secondScreen(onToggleMainScreen: (List<Boolean>) -> Unit) {
    buttonToToggleVisibility {
        onToggleMainScreen(it)
    }
}


