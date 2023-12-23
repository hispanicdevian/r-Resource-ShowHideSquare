package views

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import custom_resources.ErgoGray
import engine_logic.LSHandler
import onoff_boxes.onOffBoxes

//////////////////////////////////////////////////////////// Setting with multiple options Screen of the App
@Composable
@Preview
fun settingScreen() {
    var currentScreenA by remember { mutableStateOf(false) }

//////////////////////////////////////////////////////////// Navi Head

    if (currentScreenA) {
        onOffBoxes(
            initialVisibilityList = listOf(true, true, true, true),
            onSave = { updatedList ->
                LSHandler.sSSTFile(updatedList.joinToString(","))
            }
        )
    } else {
//////////////////////////////////////////////////////////// UI Container
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 30.dp).padding(vertical = 100.dp).padding(horizontal = 250.dp)
                .background(
                    Color.Black, shape = AbsoluteRoundedCornerShape(8.dp)
                )
                .padding(5.dp)
                .size(300.dp)
                .background((ErgoGray), shape = AbsoluteRoundedCornerShape(5.dp)),
            contentAlignment = Alignment.Center
        ) {
            val itemsList = listOf("On/Off")
            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                state = rememberLazyListState(),
                verticalArrangement = Arrangement.Center
            ) {
                items(itemsList) { item ->
                    Text(
                        color = Color.White,
                        text = item,
//////////////////////////////////////////////////////////// Navi Tail
                        modifier = Modifier
                            .clickable {
                                if (item == "On/Off") {
                                    currentScreenA = true
                                }
                            }
                            .padding(16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 30.sp)
                    )
                }
            }
        }
    }
}
