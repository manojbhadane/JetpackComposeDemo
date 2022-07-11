package com.example.jetpackcomposedemo.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposedemo.component.CustomDialog


@Composable
fun Home(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        HomePage(navController)
    }
}

@Composable
fun HomePage(navController: NavHostController){

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
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
//                Button(onClick = {
//                    showDialog.value = true
//                }) {
//                    Text(text = "Open Dialog")
//                }

            }
        }
    }
}

