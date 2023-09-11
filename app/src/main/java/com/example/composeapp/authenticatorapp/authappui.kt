package com.example.composeapp.authenticatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun AuthApp() {
    ComposeAppTheme {
        HomeScreen()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val details = listOf(
        Details(
            authName = "Microsoft",
            username = "madusankaisuruwan@gmail.com",
            icon = Icons.Default.Person
        ),
        Details(
            authName = "Covalent Systems",
            username = "madusankaisuruwan@gmail.com",
            icon = Icons.Default.Person
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            containerColor = Color(0xFFEEECEC),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Authenticator", style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = Color.White
                        )
                    },
                    scrollBehavior = scrollBehavior,
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add New",
                                tint = Color.White,
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(26.dp)
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White,
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(26.dp)
                            )
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Search",
                                tint = Color.White,
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(26.dp)
                            )
                        }
                    },
                    windowInsets = WindowInsets.displayCutout,
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color(
                            0xFF1976D2
                        )
                    ),

                    )
            },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                ) {
                    AppContent(details)
                }
            },
            bottomBar = {
                BottomNavigation()
            }
        )
    }
}

@Composable
fun BottomNavigation() {

    val selectedItem by remember {
        mutableStateOf(0)
    }

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Authenticator",
            route = "authenticator",
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Password",
            route = "password",
            icon = Icons.Default.Build
        ),
        BottomNavItem(
            name = "Payments",
            route = "payments",
            icon = Icons.Default.Home
        )
    )

    NavigationBar {
        bottomNavItems.forEachIndexed { index, items ->
            NavigationBarItem(selected = selectedItem == index,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = items.icon,
                        contentDescription = "Authenticator"
                    )
                },
                label = {
                    Text(
                        text = items.name,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Light
                    )
                })
        }
    }
}

@Composable
fun AppContent(details: List<Details>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(details) { item ->
            itemCard(imageVector = item.icon, authName = item.authName, username = item.username)
        }
    }
}

@Composable
fun itemCard(imageVector: ImageVector, authName: String, username: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .background(Color(0xFFFFFFFF))
    ) {
        Box(
            Modifier
                .fillMaxHeight()
                .width(8.dp)
                .background(Color(0xFF1976D2))
        )
        Column(verticalArrangement = Arrangement.Center) {
            Box (modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
            }
        }
    }
}

@Composable
fun Card() {
    androidx.compose.material3.Card (modifier = Modifier.fillMaxHeight()) {

    }
}

