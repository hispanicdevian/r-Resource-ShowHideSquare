package sub_views

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import custom_resources.ErgoGray
import custom_resources.NbtColor
import engine_logic.LSHandler
import engine_logic.Navi
import onoff_boxes.onOffBoxes
import views.mainScreen
import views.settingScreen

@Composable
@Preview
fun onOffBoxesSettings(
    visibilityList: List<Boolean>
) {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.OnOffBxsSettings) }

//////////////////////////////////////////////////////////// Navi Head (Navi = Navigation)
    when (currentScreen) {
        is Navi.OnOffBxsSettings -> {
//////////////////////////////////////////////////////////// Done Button
            Box(
                modifier = Modifier.fillMaxSize().padding(start = 4.dp, end = 4.dp, top = 3.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top
                ) {
                    Button(modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(ErgoGray),
                        onClick = { currentScreen = Navi.Settings }
                    ) {
                        Text("Done", color = NbtColor, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
//////////////////////////////////////////////////////////// UI Container
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 60.dp)
                    .background(ErgoGray)
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
                        onOffBoxes(
                            initialVisibilityList = visibilityList,
                            onSave = { updatedList ->
                                LSHandler.sSSTFile(updatedList.joinToString(","))
                            }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            }
        }
//////////////////////////////////////////////////////////// Navi Tail (Navi = Navigation)
        Navi.Main -> mainScreen()
        Navi.Settings -> settingScreen()
    }
}

