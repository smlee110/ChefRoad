package com.example.chefroad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.chefroad.ui.theme.ChefRoadTheme
import com.example.chefroad.feature.home.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChefRoadTheme {
                HomeScreen(onShowClick = { showName ->
                    println("$showName 클릭됨")
                })
            }
        }
    }
}
