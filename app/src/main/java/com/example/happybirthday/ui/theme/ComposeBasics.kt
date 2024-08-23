package com.example.happybirthday.ui.theme

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.R

class ComposeBasics : ComponentActivity() {
    @Composable
    fun TextCompose() {
        val painter = painterResource(id = R.drawable.bg_compose_background)

        Column {
            Image(
                painter = painter,
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.jetpack_compose_tutorial),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp),
            )
            Text(
                text = stringResource(id = R.string.middle_line),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.last_line),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }

    @Composable
    fun TaskCompleted(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = R.string.all_task_completed),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                )
                Text(
                    text = stringResource(id = R.string.nice_work),
                    fontSize = 16.sp
                )
            }

        }
    }

    @Composable
    fun Quadrant() {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.weight(1f)) {
                TextBox(
                    title = R.string.top_left_title,
                    description = R.string.top_left_description,
                    background = R.color.top_left,
                    modifier = Modifier.weight(1f)
                )
                TextBox(
                    title = R.string.top_right_title,
                    description = R.string.top_right_description,
                    background = R.color.top_right,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.weight(1f)) {
                TextBox(
                    title = R.string.bottom_left_title,
                    description = R.string.bottom_left_description,
                    background = R.color.bottom_left,
                    modifier = Modifier.weight(1f)
                )
                TextBox(
                    title = R.string.bottom_right_title,
                    description = R.string.bottom_right_description,
                    background = R.color.bottom_right,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun TextBox(
        title: Int = 0,
        description: Int = 0,
        background: Int = 0,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(colorResource(id = background)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = title),
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = description),
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun BussinessCard() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            UpCard(modifier = Modifier.weight(1f))
            ContantInfo(modifier = Modifier.weight(1f))
        }
    }

    @Composable
    fun UpCard(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .background(Color.Blue),
            // .fillMaxSize()
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "android logo"
            )
            Text(
                text = "Full Name",
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                modifier = modifier
                    .background(Color.Yellow)
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = "Title")
        }
    }

    @Composable
    fun ContantInfo(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {

            InfoCard(modifier = Modifier.weight(1f))
            InfoCard(modifier = Modifier.weight(1f))
            InfoCard(modifier = Modifier.weight(1f))
        }
    }

    @Composable
    fun InfoCard(modifier: Modifier = Modifier) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
            )
            Text(
                text = "text 1",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
    }

    @Composable
    fun DiceRoll(
        name: String = "",
        modifier: Modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var number by remember { mutableIntStateOf(1) }
            var imageSource by remember { mutableStateOf(R.drawable.dice_1) }
            Image(painter = painterResource(imageSource), contentDescription = null)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                number = (1..6).random()
                imageSource = when (number) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }

            }) {
                Text(text = stringResource(id = R.string.roll))

            }
            Text(
                text = "You got $number",
                fontSize = 32.sp
            )

        }
    }

    @Composable
    @Preview(showBackground = true)
    fun DiceRollPreview() {
        DiceRoll()
    }


    @Composable
    @Preview(showBackground = true)
    fun BussinessCardPreview() {
        BussinessCard()
    }


    @Composable
    @Preview(showBackground = true)
    fun QuadrantPreview() {
        Quadrant()

    }

    @Preview(showBackground = true)
    @Composable
    fun TaskCompletePreview() {
        TaskCompleted()
    }


    @Preview(showBackground = true)
    @Composable
    fun TextPreview() {
        TextCompose()
    }
}