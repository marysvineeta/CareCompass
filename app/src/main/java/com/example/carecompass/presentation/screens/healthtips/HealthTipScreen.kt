package com.example.carecompass.presentation.screens.healthtips

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import com.example.carecompass.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthTipScreen(navController: NavController) {
    val healthTips = listOf(
        "Stay hydrated by drinking 8 glasses of water daily.",
        "Take a 10-minute walk after meals to improve digestion.",
        "Get at least 7 hours of sleep every night.",
        "Eat at least 5 servings of fruits and vegetables per day.",
        "Limit screen time before bed for better sleep quality."
    )
    var currentTip by remember { mutableStateOf(healthTips.random()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Health Tip") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Routes.Dashboard.route) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentTip,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Button(onClick = { currentTip = healthTips.random() }) {
                Text("Show Another Tip")
            }
        }
    }
}
