package com.example.composeapp.composeNavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AnimalScreen(){
    
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController)
        }
        composable("settings"){
            SettingScreen(
                onHome = {
                    navController.popBackStack()
                },
                onProfile = {
                    navController.navigate("profile")
                }
            )
        }
        composable("profile"){
            ProfileScreen  {
                navController.popBackStack("home",false)
            }
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavController
){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Home Screen")
        Button(onClick = {
            navController.navigate("settings")
        }) {
            Text(text = "Go to Settings")
        }
    }
}

@Composable
fun SettingScreen(onHome: () -> Unit, onProfile: () -> Unit){

    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Settings Screen")
        Button(onClick = {
            onHome
        }) {
            Text(text = "Go to Home")
        }
    }
}

@Composable
fun ProfileScreen(onHome: () -> Unit){

    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Profile Screen")
        Button(onClick = {
            onHome
        }) {
            Text(text = "Go to Home")
        }
    }
}


