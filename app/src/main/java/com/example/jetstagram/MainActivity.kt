package com.example.jetstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetstagram.ui.screens.home.HomeScreen
import com.example.jetstagram.ui.theme.JetstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetstagramTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()
            }
        }
    }
}

