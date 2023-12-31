package mainscreen_boxes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import engine_logic.LSHandler
import engine_logic.Navi
import sub_views.onOffBoxesSettings

//////////////////////////////////////////////////////////// Ping Boxes Shown in the First Column of the Main Screen
@Composable
fun pingBoxesA() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.Main) }
    val titleList = listOf("Square 0", "Square 1", "Square 2", "Square 3")

    val visibilityList = remember {
        val currentState = LSHandler.lSSTFile() // Load the state from the file

        if (currentState.isNotEmpty()) {
            // If the loaded state is not empty, parse it and use it
            currentState.split(",").map { it.toBoolean() }.toMutableList()
        } else {
            // If the file is empty or couldn't be read, use a default state
            mutableStateListOf(true, true, true, true)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (currentScreen) {
                is Navi.Main -> {
                    Spacer(modifier = Modifier.height(15.dp))

                    for (index in titleList.indices) {
                        if (visibilityList[index]) {
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
                                        text = titleList[index],
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

                Navi.OnOffBxsSettings -> TODO()
                Navi.Settings -> TODO()
            }
        }
    }
}
