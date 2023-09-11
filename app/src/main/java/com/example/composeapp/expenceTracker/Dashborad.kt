package com.example.composeapp.expenceTracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.ui.theme.ExpenseFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {
    Scaffold(
        topBar = { ExpenseAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            color = Color(0xFFF9F9F9)
        ) {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Surface (modifier = Modifier.fillMaxWidth().height(120.dp).align(Alignment.CenterHorizontally), color = Color.White) {
                    Text(text = "Total Balance", textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseAppBar() {
    TopAppBar(
        title = {
            Row (modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Dashboard",
                    style = TextStyle(
                        fontFamily = ExpenseFontFamily,
                        fontWeight = FontWeight.W600,
                        letterSpacing = 0.03.sp,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF000000)
                    )
                )
//                Spacer(modifier = Modifier.width(16.dp))
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowDown,
//                        contentDescription = "",
//                        modifier = Modifier
//                            .width(24.dp)
//                            .height(24.dp)
//                    )
//                }
            }
        },
        windowInsets = WindowInsets.statusBars,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon), contentDescription = "back button",
                    tint = Color.Black,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert, contentDescription = "back button",
                    tint = Color.Black
                )
            }
        }
    )
}