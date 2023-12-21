import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun magicButton(visibilityList: List<Boolean>, onToggle: (List<Boolean>) -> Unit) {
    Column {
        repeat(4) { index ->
            Row {
                Button(
                    onClick = {
                        val updatedList = visibilityList.toMutableList()
                        updatedList[index] = !updatedList[index]
                        onToggle(updatedList)
                    }
                ) {
                    Text(text = if (visibilityList[index]) "OFF" else "ON")
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}