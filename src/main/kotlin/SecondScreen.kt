import androidx.compose.runtime.Composable

@Composable
fun secondScreen(visibilityList: List<Boolean>, onToggle: (List<Boolean>) -> Unit) {
    magicButton(visibilityList) { updatedList ->
        onToggle(updatedList)
    }
}