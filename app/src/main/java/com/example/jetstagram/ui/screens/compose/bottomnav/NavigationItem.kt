package com.example.jetstagram.ui.screens.compose.bottomnav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
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
        backgroundColor = colorResource(id = R.color.purple_500),
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

@Preview
@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontFamily = FontFamily(Font(R.font.helvetica_neue_black_cond)),
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.AddBox,
                    contentDescription = "Create Post"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Message,
                    contentDescription = "Direct Message"
                )
            }
        },
        backgroundColor = colorResource(id = R.color.purple_500),
    )
}