package views

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import custom_resources.Purple80
import engine_logic.Navi
import mainscreen_boxes.pingBoxesA
import sub_views.onOffBoxesSettings

//////////////////////////////////////////////////////////// Main/First Screen of the App
@Composable
@Preview
fun mainScreen() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.Main) }
    val visibilityList = remember { mutableStateOf(listOf(true, true, true, true)) }

//////////////////////////////////////////////////////////// UI Container
    Box(
        modifier = Modifier.fillMaxSize().background(Color.DarkGray)
    ) {
        TopAppBar(
            backgroundColor = Purple80,
            modifier = Modifier.fillMaxWidth()
        ) {
//////////////////////////////////////////////////////////// Clickable Title
            Text("Main Screen",
                fontSize = 26.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.W900,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { currentScreen = Navi.Main }
                    )
            )
        }
//////////////////////////////////////////////////////////// Home Button
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 17.dp, start = 20.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false, radius = 15.dp),
                        onClick = { currentScreen = Navi.Main }
                    )
            ) {
                Image(
                    painter = painterResource("HomePng240.png"),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
//////////////////////////////////////////////////////////// Settings Button
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 17.dp, end = 22.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false, radius = 15.dp),
                        onClick = { currentScreen = Navi.Settings }
                    )
            ) {
                Image(
                    painter = painterResource("SettingsPng240F.png"),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
//////////////////////////////////////////////////////////// Navi Head
        when (currentScreen) {
            is Navi.Main -> {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 55.dp)
                        .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
//////////////////////////////////////////////////////////// Box Set A
                    pingBoxesA()
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
//////////////////////////////////////////////////////////// Navi Tail
            Navi.OnOffBxsSettings -> onOffBoxesSettings((visibilityList.value))
            Navi.Settings -> settingScreen()
        }
    }
}
