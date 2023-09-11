package com.example.composeapp.flow

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun KotlinFlow() {

    val kotlinViewModel = viewModel<FlowViewModel>()

    val countDownValue = kotlinViewModel.countDownFlow.collectAsState(initial = 10)

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = countDownValue.value.toString(),
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 24.sp
            )
        )
        Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Reset", fontSize = 18.sp)
        }
    }
}