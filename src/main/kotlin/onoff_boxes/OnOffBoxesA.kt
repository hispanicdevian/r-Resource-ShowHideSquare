package onoff_boxes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import engine_logic.LSHandler

@Composable
fun onOffBoxes(
    initialVisibilityList: List<Boolean>,
    onSave: (List<Boolean>) -> Unit // Save function
) {
    var visibilityList by remember { mutableStateOf(initialVisibilityList) }

    LaunchedEffect(Unit) {
        val currentState = LSHandler.lSSTFile()
        visibilityList = if (currentState.isNotEmpty()) {
            currentState.split(",").map { it.toBoolean() }
        } else {
            initialVisibilityList
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().padding(top = 60.dp)
            .background(Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
//////////////////////////////////////////////////////////// Box Set A
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                // Iterate through the visibility list indices to create clickable boxes
                visibilityList.forEachIndexed { index, isVisible ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (isVisible) Color.Black else Color.DarkGray,
                                shape = AbsoluteRoundedCornerShape(8.dp)
                            )
                            .padding(5.dp)
                            .weight(1f)
                            .aspectRatio(1.5f)
                            .clickable {
                                visibilityList = visibilityList.toMutableList().apply {
                                    this[index] = !this[index]
                                }
                                onSave(visibilityList) // Save the updated state when the box is clicked
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = if (isVisible) "ON" else "OFF", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
