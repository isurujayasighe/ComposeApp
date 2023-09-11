package com.example.composeapp.layoutConfig

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LayoutConfigMain(){
    LazyColumn( modifier = Modifier.padding(16.dp)){
        item {
            TitleComponent(title = "Child views with equal weights")
            RowEqualWeightComponent()
        }

        item {
            TitleComponent(title = "Child views with unequal weights")
            RowUnequalWeightComponent()
        }
    }
}

@Composable
fun RowEqualWeightComponent(){

    Row (modifier = Modifier.fillMaxWidth()){
        Button(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .weight(1f)) {
            Text(text = "Login", style = TextStyle(fontSize = 16.sp))
        }

        Button(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .weight(1f)) {
            Text(text = "Register", style = TextStyle(fontSize = 16.sp))
        }
    }
}

@Composable
fun RowUnequalWeightComponent(){
    Row (modifier = Modifier.fillMaxWidth()){
        Button(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .weight(0.6f)) {
            Text(text = "Login", style = TextStyle(fontSize = 16.sp))
        }

        Button(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .weight(0.4f)) {
            Text(text = "Register", style = TextStyle(fontSize = 16.sp))
        }
    }
}



@Composable
fun TitleComponent(title: String){
    Text(text = title, color = Color.Blue, modifier = Modifier.padding(10.dp))
}