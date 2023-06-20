package test2223t2

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application


@Composable
fun Stars(rating: Int, max: Int, onChange: (Int) -> Unit) {
    Row {
        for (n in 1..max) {
            Box(modifier = Modifier.clickable {
                onChange(n) }) {
                Image(
                    painter = painterResource(
                        if (n <= rating) "star-full.png" else "star-empty.png"),
                    contentDescription = "",
                    modifier = Modifier.size(55.dp)
                )
            }

        }
    }
}

@Composable
fun ScoreStars(score: Score?, max: Int, onChange: (Score) -> Unit) {
    Column(modifier = Modifier.width(275.dp)) {
        if (score != null) {
            Stars(
                score.rating,
                max, onChange = {
                onChange(Score(score.name,it))
            })
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(score.name, textAlign = TextAlign.Center)
            }

        } else Stars(0, max, onChange = { })
    }
}


@Composable
fun ScoreList(values: List<Score>, onSelect: (Score) -> Unit) {
    Column {
        Box(modifier = Modifier.fillMaxSize().padding(5.dp).border(2.dp, Color.DarkGray)) {
            Column(modifier = Modifier.padding(5.dp)) {
                values.forEach {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(it.name)
                        Button(onClick = { if (it.rating != null) onSelect(it) }) { Text("${it.rating}") }
                    }
                }
            }
        }
    }
}


@Composable
fun ScoreView(lst: List<Score>, maxRating: Int) {

    var sc = remember { mutableStateOf<List<Score>>(lst)}   //pq n pode ser by?
    var current = remember { mutableStateOf<Score>(sc.value.first())}

    Row{
        ScoreStars(sc.value.find{current.value == it}, maxRating) {
                new -> sc.value = sc.value.replace(new)
        }
        ScoreList(lst) { new -> current.value = new }
    }

}

const val MAX_RATING = 5
fun main() {
    val musics: List<Score> = listOf(Score("a ", 1), Score("bb ", 2), Score("ccc ", 3), Score("eeee ", 4))
    application(exitProcessOnExit = false) {
        val winState = WindowState(width = 450.dp, height = 250.dp)
        Window(onCloseRequest = ::exitApplication, state = winState, title = "Music") {
            ScoreView(musics, MAX_RATING)
        }
    }
}

/*
const val MAX_RATING = 3
fun main() {
    val movies: List<Score> = ...
    application {
        val winState = WindowState(...)
        Window(state = winState, ...) {
        ScoreView(movies, MAX_RATING)
    }
    }
}*/