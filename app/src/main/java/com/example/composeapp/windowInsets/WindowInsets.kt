package com.example.composeapp.windowInsets


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun BaseWindowInsets() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        LazyColumn(modifier = Modifier.weight(1f).imeNestedScroll(), reverseLayout = true){
            items(100) {index ->
                Text(text = "item $index", Modifier.padding(16.dp))
            }
        }
        var username by remember {
            mutableStateOf(TextFieldValue())
        }
        
        Box {
            TextField(value = username, onValueChange = {
                                                          username = it
            }, modifier = Modifier
                .fillMaxWidth().imePadding(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFBDBDBD)
                ),

                placeholder = {
                    Text(text = "${WindowInsets.isImeVisible}")
                }

            )
        }
    }
}
