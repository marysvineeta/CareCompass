package com.example.carecompass.presentation.screens.quote

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carecompass.presentation.viewmodel.QuoteViewModel
import com.example.carecompass.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(
    navController: NavController,
    viewModel: QuoteViewModel = viewModel()
) {
    val quote by viewModel.quote.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchQuote()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quote of the Day") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Routes.Dashboard.route) }) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            quote?.let {
                Text(
                    text = "\"${it.q}\"",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "- ${it.a}",
                    style = MaterialTheme.typography.bodyLarge
                )
            } ?: Text("Loading...")

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { viewModel.fetchQuote() }) {
                Text("Get Another Quote")
            }
        }
    }
}

