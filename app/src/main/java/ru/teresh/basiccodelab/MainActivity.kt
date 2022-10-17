package ru.teresh.basiccodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.teresh.basiccodelab.ui.theme.BasicCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                val texts = listOf<String>("Word", "Compose", "Kotlin", "Tony", "DombaBomba")
                MyApp(texts)
            }
        }
    }
}


@Composable
@Preview
fun PreviewMyApp() {
    val texts = listOf<String>("Word", "Compose", "Kotlin", "Tony", "DombaBomba")
    MyApp(texts)
}

@Composable
fun MyApp(texts: List<String>) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(8.dp)
    ) {
        LazyColumn() {
            items(texts) { text ->
                MyBlock(body = text)
            }
        }
    }
}

@Composable
fun MyBlock(body: String) {
    var isShowedMore by remember { mutableStateOf(false) }
    val extraPadding = if (isShowedMore) 48.dp else 0.dp
    Row(
        modifier = Modifier
            .padding(16.dp)
            .padding(bottom = extraPadding)
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colors.secondary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.padding(horizontal = 6.dp)) {
            Text(text = "Hello,")
            Text(text = body)
        }
        OutlinedButton(
            onClick = { isShowedMore = !isShowedMore },
            modifier = Modifier.padding(horizontal = 6.dp)
        ) {
            if (!isShowedMore) Text(text = "Show more")
            else Text(text = "Show less")
        }
    }
}


