package com.wanderlei.cutomalertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.wanderlei.cutomalertdialog.ui.theme.CutomAlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CutomAlertDialogTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    CustomDialogScreen()
                }
            }
        }
    }
}

@Composable
fun CustomDialogScreen() {

    val openAlert = remember {
        mutableStateOf(false)
    }

    Button(
        onClick = { openAlert.value = true },
        modifier = Modifier
            .width(200.dp)
            .height(46.dp)
    ) {
        Text(text = "Click me")
    }

    if (openAlert.value) CustomDialogUI(openAlert)
}

@Composable
fun CustomDialogUI(openDialogBox: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialogBox.value = false }) {
        CustomUI(openDialogBox)
    }
}

@Composable
fun CustomUI(openDialog: MutableState<Boolean>) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(
                    color = Color.Magenta
                ),
                modifier = Modifier
                    .padding(top = 35.dp)
                    .height(70.dp)
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Get Updates",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Allow permission to send notifications when new update added on play",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp, 25.dp, 25.dp, 25.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(
                        text = "Not now", fontWeight = FontWeight.Bold, color = Color.Red,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
                TextButton(onClick = { openDialog.value = false }) {
                    Text(
                        text = "Allow", fontWeight = FontWeight.Bold, color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }

        }
    }
}



