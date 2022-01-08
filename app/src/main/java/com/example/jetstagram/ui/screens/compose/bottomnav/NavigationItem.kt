package com.example.jetstagram.ui.screens.compose.bottomnav

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetstagram.R

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object Search : NavigationItem("search", Icons.Default.Search, "Search")
    object Reels : NavigationItem("reels", Icons.Default.VideoLibrary, "Reels")
    object Notifications : NavigationItem("notifications", Icons.Default.Favorite, "Notifications")
    object Profile : NavigationItem("profile", Icons.Default.Person, "Profile")
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Reels,
        NavigationItem.Notifications,
        NavigationItem.Profile,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_200),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route, onClick = {
                    navController.navigate(navItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        navItem.icon, contentDescription = navItem.title
                    )
                },
                label = { Text(text = navItem.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f)
            )
        }

    }
}

@Composable
fun TopAppBar() {
    TopAppBar(
    ) {
        Text(text = "Instagram", fontSize = 18.sp)
    }
}