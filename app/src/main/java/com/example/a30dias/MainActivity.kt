package com.example.a30dias

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30dias.Days.Days
import com.example.a30dias.Days.datList
import com.example.a30dias.ui.theme._30diasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30diasTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column {
        TopAppBar(
            title = {
                Text(
                    text = "30 Days App",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
        ListDays(listdats = datList)
    }

}

@Composable
fun ListDays(listdats : List<Days>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(listdats){ day ->
            DayCard(daycart = day,modifier = Modifier.padding(8.dp))

        }
    }
}

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun DayCard(daycart: Days, modifier: Modifier = Modifier){
    val expandedState = remember { mutableStateOf(false) }
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primary
    ),
        modifier= modifier
            .graphicsLayer(scaleY = animateFloatAsState(if (expandedState.value) 1.1f else 1f).value)) {
        Column {
            Row(modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp, bottom = 5.dp, top = 8.dp)){
                Text(text = LocalContext.current.getString(daycart.tittle),
                    fontFamily = FontFamily(Font(R.font.poppins_bold),
                        Font(R.font.poppins_regular)),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = daycart.number_day.toString(),
                    fontFamily = FontFamily(Font(R.font.poppins_bold),
                        Font(R.font.poppins_regular))
                )
            }

            Text(text = LocalContext.current.getString(daycart.name),
                fontFamily = FontFamily(Font(R.font.poppins_bold, FontWeight.ExtraBold),
                ),modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Start))

            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier.clickable { expandedState.value = !expandedState.value }) {
                Image(
                    painter = painterResource(id = daycart.pic),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedState.value = !expandedState.value }

                )
            }
            if (expandedState.value
            ) {
                Text(color = Color.LightGray,
                    text = LocalContext.current.getString(daycart.content),
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 8.dp)
                        .align(Alignment.Start)
                    ,
                    fontFamily = FontFamily(Font(R.font.poppins_regular, FontWeight.Light
                        ,),
                    )
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(26.dp))
}

@Composable
fun Content(daycart: Days) {
    val transition = updateTransition(targetState = true)
    val scaleY by transition.animateDp(
        transitionSpec = {
            tween(durationMillis = 300, easing = FastOutSlowInEasing)
        }
    ) { state ->
        if (state) 0.dp else 24.dp
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(scaleY)
    ) {
        Text(text = LocalContext.current.getString(daycart.content))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30diasTheme {
        Greeting("Android")
    }
}