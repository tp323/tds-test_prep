package test2222t2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.singleWindowApplication
import test2122t1.MainContent


fun main() = singleWindowApplication(
    title = "Quotation Demo",
    state = WindowState(width= 280.dp, height= 130.dp),
) { MaterialTheme {
    DemoEvalEdit( Grade(4) ) { partial: Double ->
        println("Partial = ${partial.format(2)}")
    }
} }
fun Double.format(digs: Int) = "%.${digs}f".format(this)

@Composable
fun SymbolButton(symbol: Char, enabled: Boolean, onClick: ()->Unit) {
    Button(onClick = onClick, enabled = enabled) {
        Text("$symbol")
    }
}

@Composable
fun EvalEdit(eval: Eval, set: (Eval)->Unit) {
    Row(
        modifier = Modifier.border(2.dp, Color.Gray ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SymbolButton('-', eval.quotation != Eval.MIN ) { set(eval.dec()) }
        TextField(
            value = "${eval.quotation}",
            onValueChange = { txt ->
                txt.toIntOrNull()?.let { q -> Eval.of(q)?.let { set(it) } }
            },
            modifier = Modifier.width(65.dp)
        )
        Text("%")
        SymbolButton('+', eval.quotation != Eval.MAX ) { set(eval.inc()) }
    }
}

@Composable
fun DemoEvalEdit(grade: Grade, onChange: (Double)->Unit) {
    var eval by remember { mutableStateOf(Eval.default) }
    val partial = grade.partialValue(eval)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EvalEdit(eval) {
            eval = it
            onChange(grade.partialValue(it))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("of ${grade.value} values = ")
            Text("${partial.format(2)}", style = MaterialTheme.typography.h4)
        }
    }
}
/*
@Composable
fun SymbolButton(symbol: Char, enabled: Boolean, onClick: () -> Unit) =
    Button(onClick = onClick, enabled = enabled) { Text("$symbol") }

@Composable
fun EvalEdit(eval: Eval/*, updater: (Int) -> Double*/) {
    var percent by remember { mutableStateOf<Int>(eval.quotation) }
    var res by remember { mutableStateOf<Double>(20.0) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(Modifier.fillMaxWidth().padding(10.dp, 0.dp, 10.dp, 40.dp).border(2.dp, Color.DarkGray)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.width(83.dp), horizontalAlignment = Start) {
                        SymbolButton('-', eval.quotation != 0) {
                            eval.dec()
                        }
                    }
                    Column(modifier = Modifier.width(83.dp), horizontalAlignment = CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.fillMaxWidth(.8f)) {
                                TextField(
                                    value = "$percent",
                                    onValueChange = { newInput: String -> percent = newInput.toInt() })
                            }
                            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                                Text("%")
                            }


                        }
                    }
                    Column(modifier = Modifier.width(89.dp), horizontalAlignment = CenterHorizontally) {
                        SymbolButton('+', eval.quotation != 20) {
                            eval.inc()
                        }
                    }
                }
            }
            Row() {
                Text("of $res")
            }
        }
    }
}

@Composable
fun DemoEvalEdit(grad: Grade, partial: (Double) -> Unit) {

}


fun main() = singleWindowApplication(
    title = "Quotation Demo",
    state = WindowState(width = 280.dp, height = 130.dp),
) {
    MaterialTheme {
        DemoEvalEdit(Grade(4)) { partial: Double ->
            println("Partial = ${partial.format(2)}")
        }
        EvalEdit(Eval(5))
    }
}

fun Double.format(digs: Int) = "%.${digs}f".format(this)*/