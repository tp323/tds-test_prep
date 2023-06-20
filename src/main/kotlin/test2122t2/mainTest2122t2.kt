package test2122t2

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
fun TaskNameEditor(onAdd: (Task) -> Unit, onRemove: (Task) -> Unit) {
    var input by remember { mutableStateOf<String>("") }
    Column(modifier= Modifier.width((450/2-5).dp), horizontalAlignment=CenterHorizontally) {
        TextField(value = input, onValueChange = {newInput -> input=newInput})
        Button(onClick={onAdd(Task(input))}, enabled = input.length in 4..40){Text("Add")}
        Button(onClick={onRemove(Task(input))}, enabled = input.length in 4..40){Text("Remove")}

    }
}

@Composable
fun StringListView(title: String, values: List<String>) {
    Column(modifier= Modifier.fillMaxWidth().padding(10.dp,0.dp,0.dp,0.dp)) {
        Text(title, fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().border(2.dp, Color.LightGray)) {
            Column(modifier= Modifier.fillMaxWidth(), horizontalAlignment=CenterHorizontally) {
                values.forEach { value -> Text(value) }
            }
        }
    }
}

fun main() = application(exitProcessOnExit = false) {
    val state = WindowState(width = 450.dp, height = 200.dp)
    val todo = remember { mutableStateOf(TodoList()) }
    Window(onCloseRequest = ::exitApplication, state = state, title = "Todo List") {
        Row(Modifier.padding(5.dp)) {
            TaskNameEditor(
                onAdd = { t: Task -> todo.value = todo.value.add(t) },
                onRemove = { t: Task -> todo.value = todo.value.remove(t) }
            )
            StringListView(title = "Tasks:", values = todo.value.tasks.map { it.name })
        }
    }
}