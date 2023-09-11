package com.example.composeapp.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.CounterState
import com.example.composeapp.TitleComponent

@Composable
fun ModelComponent(){

    var counterState by remember { mutableStateOf(CounterState()) }

    Column {
        TitleComponent(title = "Example using Model class to store state")
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.White)) {

            Button(modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                ,onClick = {
                    counterState = counterState.copy(counter = counterState.counter+1)
                }) {
                Text(text = "Increment", modifier = Modifier.padding(16.dp), fontSize = 16.sp )
            }

            Button(modifier = Modifier
                .padding(16.dp)
                .weight(1f),
                elevation = ButtonDefaults.buttonElevation(4.dp)
                ,onClick = {
                    counterState = counterState.copy(counter = 0)
                }) {
                Text(text = "Reset", modifier = Modifier.padding(16.dp), fontSize = 16.sp )
            }
        }

        Text(text = "Counter value is ${counterState.counter}", modifier = Modifier.padding(16.dp))
    }
}