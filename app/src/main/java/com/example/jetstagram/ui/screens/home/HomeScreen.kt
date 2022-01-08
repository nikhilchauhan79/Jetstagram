package com.example.jetstagram.ui.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetstagram.ui.screens.compose.bottomnav.BottomNavigationBar
import com.example.jetstagram.ui.screens.compose.bottomnav.NavigationItem
import com.example.jetstagram.ui.screens.compose.bottomnav.TopAppBar
import com.example.jetstagram.ui.screens.profile.ProfileScreen

@Preview
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Search.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Reels.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Notifications.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}