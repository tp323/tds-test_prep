package test2122t1

import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import kotlin.system.exitProcess

const val DEFAULT_CAPACITY = 20
@Composable
fun MainContent() {
    var occupancy by remember { mutableStateOf(Occupancy(0,DEFAULT_CAPACITY))}
    Row (Modifier.fillMaxWidth(), Arrangement.SpaceEvenly, Alignment.CenterVertically){
        Column {
            OccupancyView(occupancy)
        }
        Column{
            Button(onClick = { occupancy=occupancy.increment() }, enabled = !occupancy.isFull){ Text("+") }
            Button(onClick = { occupancy=occupancy.decrement() }, enabled = !occupancy.isEmpty){ Text("-") }
        }

    }
}

@Composable
fun OccupancyView(occup: Occupancy) {
    Column(horizontalAlignment=Alignment.CenterHorizontally) {
        Text("${occup.current}", fontWeight = FontWeight.Bold)
        Text("of")
        Text("${occup.capacity}", fontWeight = FontWeight.Bold)
    }

}


fun main() = application(exitProcessOnExit = false){
    MaterialTheme {
        val state = WindowState(width = 250.dp, height = Dp.Unspecified)
        Window(onCloseRequest = ::exitApplication, state = state, title = "Occupancy") {
            MainContent()
        }
    }
}