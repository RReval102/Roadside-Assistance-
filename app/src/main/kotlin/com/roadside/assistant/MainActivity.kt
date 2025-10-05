package com.roadside.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.roadside.assistant.ui.theme.RoadsideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoadsideTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavHost()
                }
            }
        }
    }
}
