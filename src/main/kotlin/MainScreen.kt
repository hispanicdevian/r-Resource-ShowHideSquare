import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun mainScreen() {
    val titleList = listOf("Square 0", "Square 1", " Square 2", "Square 3")
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(15.dp))
//////////////////////////////////////////////////////////// It will multiply content times 4
            repeat(4) {
                Box(
                    modifier = Modifier
                        .background(color = Color.Black, shape = AbsoluteRoundedCornerShape(8.dp))
                        .padding(5.dp)
                        .weight(1f)
                        .aspectRatio(1.5f)
                        .background(
                            (Color.DarkGray),
                            shape = AbsoluteRoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = titleList[it],
                            color = Color.White,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Subtitle",
                            color = Color.White,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}