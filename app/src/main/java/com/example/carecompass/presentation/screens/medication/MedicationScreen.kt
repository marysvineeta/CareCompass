package com.example.carecompass.presentation.screens.medication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carecompass.presentation.navigation.Routes
import com.example.carecompass.presentation.viewmodel.MedicationViewModel
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicationScreen(navController: NavController, viewModel: MedicationViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    val medications by viewModel.medications.collectAsState()
    val context = LocalContext.current


    // 👇 Add a default medication once, only if the list is empty
    LaunchedEffect(Unit) {
        if (medications.isEmpty()) {
            viewModel.addMedication("Paracetamol", "8:00 AM after breakfast")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Medication Reminders") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Routes.Dashboard.route) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Medication Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Time (e.g., 9:00 AM)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && time.isNotBlank()) {
                        viewModel.addMedication(name, time)
                        Toast.makeText(context, "Medication added!", Toast.LENGTH_SHORT).show()
                        name = ""
                        time = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add Medication")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(medications) { med ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = med.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = "Time: ${med.time}")
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { viewModel.deleteMedication(med.id) },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                            ) {
                                Text("Delete", color = MaterialTheme.colorScheme.onError)
                            }
                        }
                    }
                }
            }
        }
    }
}
