package com.example.jetpackcomposedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.component.CustomDialog
import com.example.jetpackcomposedemo.component.SegmentedControl
import com.example.jetpackcomposedemo.screen.ScreenMain
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomePage()
//                    ScreenMain()
                }
            }
        }
    }
}

@Composable
fun HomePage(){



    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        CustomDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) {
            Log.i("HomePage","HomePage : $it")
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                }
            )
        }) {
        Box(modifier = Modifier.background(Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
//                Box(modifier = Modifier
//                    .border(1.dp, Color.Gray)
//                    .clip(RoundedCornerShape(5.dp))) {
//                    Text(
//                        modifier = Modifier.padding(20.dp),
//                        text = "Lorem Ipsum is simply dummy text of the printing and typesetting",
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                }
//
//                Button(onClick = {
//                    showDialog.value = true
//                }) {
//                    Text(text = "Open Dialog")
//                }
                val items = listOf("One", "Two", "Three", "Four")
                SegmentedControl(items = items, defaultSelectedItemIndex = 0,
                    useFixedWidth = false, itemWidth = 100.dp,onItemSelection = {
                    Log.e("CustomToggle", "Selected item : ${items[it]}")
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        ScreenMain()
    }
}