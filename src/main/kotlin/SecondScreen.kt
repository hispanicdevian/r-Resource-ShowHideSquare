import androidx.compose.runtime.Composable


@Composable
fun secondScreen(
    visibilityList: List<Boolean>,
    onToggle: (List<Boolean>) -> Unit
) {
    magicButton(
        initialVisibilityList = visibilityList,
        onToggle = onToggle,
        onSave = { updatedList ->
            LSHandler.sSSTFile(updatedList.joinToString(","))
        }
    )
}